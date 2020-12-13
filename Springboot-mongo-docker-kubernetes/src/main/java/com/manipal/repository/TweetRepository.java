package com.manipal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.manipal.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, Integer>{

}
