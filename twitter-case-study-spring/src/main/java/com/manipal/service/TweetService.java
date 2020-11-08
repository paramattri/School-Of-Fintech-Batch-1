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

	public String addOrUpdateTweet(Tweet tweet) {
		tweetRepository.save(tweet);
		return "You have Successfully Tweeted!";
	}

	public List<Tweet> retrieveTweetsByUserName(String userName) {
		return tweetRepository.findByUserName(userName);
	}
	
	public Tweet retrieveTweetsByTweetId(int tweetId) {
		return tweetRepository.findById(tweetId).orElse(null);
	}
	
	public List<Tweet> retrieveAllTweets() {
		return tweetRepository.findAll();
	}

	public void deleteTweetByTweetName(String tweet) {
		tweetRepository.deleteByTweet(tweet);
	}

	public void deleteTweetById(int tweetId) {
		tweetRepository.deleteById(tweetId);
	}
	
	public List<String> trendingTweets(){
		return tweetRepository.trendingTweets();
	}
}
