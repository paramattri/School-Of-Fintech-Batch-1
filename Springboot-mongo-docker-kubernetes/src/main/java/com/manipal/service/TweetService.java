package com.manipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Tweet;
import com.manipal.repository.TweetRepository;


@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	public Tweet addTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	public List<Tweet> retrieveTweet() {
		return tweetRepository.findAll();
	}

	public void deleteTweet(Integer id) {
		tweetRepository.deleteById(id);
	}
}
