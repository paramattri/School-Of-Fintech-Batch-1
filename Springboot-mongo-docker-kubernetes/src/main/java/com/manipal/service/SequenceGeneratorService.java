package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.manipal.model.DatabaseSequence;

@Service
public class SequenceGeneratorService {
	
	@Autowired
    private MongoOperations mongoOperation;
	
	public int generateSequence(String seqName) {
		Query query = new Query(Criteria.where("_id").is(seqName));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
	    options.returnNew(true).upsert(true);
		DatabaseSequence counter = mongoOperation.findAndModify(query, update, options, DatabaseSequence.class);
		return counter.getSeq();
	}
}
