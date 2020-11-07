package com.manipal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

	List<Tweet> findByUserName(String userName);

	void deleteByTweet(String tweet);

}
