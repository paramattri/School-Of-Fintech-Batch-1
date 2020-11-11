package com.manipal.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Tweet;
import com.manipal.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;

	public void addOrUpdateTweet(Tweet tweet) {
		tweetRepository.save(tweet);
	}

	public List<Tweet> retrieveTweetsByUserName(String userName) {
		return tweetRepository.findByUserName(userName);
	}
	
	public Tweet retrieveTweetsByTweetId(int tweetId) {
		return tweetRepository.findById(tweetId).orElse(null);
	}
	
	public List<Tweet> retrieveAllTweets(String keyword) {
		if(keyword != null)
			return tweetRepository.search(keyword);
		
		return tweetRepository.findAll();
	}

	public void deleteTweetByTweetName(String tweet) {
		tweetRepository.deleteByTweet(tweet);
	}

	public void deleteTweetById(int tweetId) {
		tweetRepository.deleteById(tweetId);
	}
	
	public LinkedHashMap<String, String> trendingTweets(){
		LinkedHashMap<String, String> trendingTweets = new LinkedHashMap<>();
		List<String> trends = tweetRepository.trendingTweets();
		for(String trend : trends) {
			String[] trendSplit = trend.split(",");
			trendingTweets.put(trendSplit[0], trendSplit[1]);
		}
		return trendingTweets;
	}
}
