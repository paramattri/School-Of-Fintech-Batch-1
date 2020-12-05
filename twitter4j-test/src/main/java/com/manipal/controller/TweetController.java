package com.manipal.controller;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.service.TwitterData;

import twitter4j.Status;
import twitter4j.TwitterException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {
	
	@Autowired
	private TwitterData twitterData;
	
//	@GetMapping("/twitter")
//	public String tweetData() throws TwitterException {
//		twitterData.searchTweets();
//		return "Working";
//	}
	
//	@GetMapping("/twitter")
//	public String tweetData() throws TwitterException {
//		twitterData.searchStreamTweets();
//		return "Working";
//	}
	
	@GetMapping("/twitter")
	public String tweetData() throws TwitterException, InterruptedException {
		twitterData.sendDataToKafka();
		return "Sending Data to Kafka";
	}
}
