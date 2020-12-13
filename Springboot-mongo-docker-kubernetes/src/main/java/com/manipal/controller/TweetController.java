package com.manipal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Tweet;
import com.manipal.service.SequenceGeneratorService;
import com.manipal.service.TweetService;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	@PostMapping("/tweet")
	public Tweet addTweet(@RequestBody Tweet tweet) {
		tweet.setTweetId(sequenceGenerator.generateSequence(Tweet.SEQUENCE_NAME));
		tweet.setTweetCreationTime(LocalDateTime.now());
		return tweetService.addTweet(tweet);
	}
	
	@GetMapping("/tweets")
	public List<Tweet> retrieveTweets(){
		return tweetService.retrieveTweet();
	}
	
	@DeleteMapping("/tweet/{id}")
	public String deleteTweet(@PathVariable Integer id) {
		tweetService.deleteTweet(id);
		return "Tweet with Id: "+id+" deleted";
	}
}
