package com.manipal.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.demo.beans.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, Integer> {
	
	Country findByName(String countryName);
	List<Country> findByLanguage(String language);
	
	@Query("{'population':{'$gte': ?0}}")
	List<Country> findByPopulationGreater(Integer population);
	
}
