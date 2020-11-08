package com.manipal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Tweet;
import com.manipal.service.TweetService;
import com.manipal.util.CurrentUserNameUtil;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/twitter")
	public String homePage() {
		return "Welcome To Twitter Clone!!\nVisit different URLs for some fun. Enjoy!";	
	}
	
	@PostMapping("/twitter/user/{userName}/tweet")
	public String addTweet(@PathVariable String userName, @RequestBody Tweet tweet) {
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			tweet.setUserName(userName);
			tweet.setCreationTime(LocalDateTime.now());
			return tweetService.addOrUpdateTweet(tweet);
		}
			return "Add Tweet After Login!";
	}
	
	@GetMapping("/twitter/user/{userName}/tweets")
	public List<Tweet> retrieveTweetsByUserName(@PathVariable String userName){
			return tweetService.retrieveTweetsByUserName(userName);
	}
	
	@GetMapping("/twitter/user/{userName}/tweetId/{tweetId}")
	public Tweet retrieveTweetsByTweetId(@PathVariable String userName, @PathVariable int tweetId){
			return tweetService.retrieveTweetsByTweetId(tweetId);
	}
	
	@GetMapping("/twitter/tweets")
	public CollectionModel<Tweet> retrieveAllTweets(){
		List<Tweet> tweets = tweetService.retrieveAllTweets();
		WebMvcLinkBuilder linkBuilder =  linkTo(methodOn(TweetController.class).trendingTweets());
		CollectionModel<Tweet> collectionModel = CollectionModel.of(tweets);
		collectionModel.add(linkBuilder.withRel("Trending Tweets"));
		return collectionModel;
	}
	
	@DeleteMapping("/twitter/user/{userName}/tweets/{tweet}")
	public String deleteTweetByTweetName(@PathVariable String userName, @PathVariable String tweet) {
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			tweetService.deleteTweetByTweetName(tweet);
			return "Tweet: "+tweet+" Successfully Deleted!";
		}
		return "Delete Tweet After Login!";
	}
	
	@DeleteMapping("/twitter/user/{userName}/tweetId/{tweetId}")
	public String deleteTweetById(@PathVariable String userName, @PathVariable int tweetId) {
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			tweetService.deleteTweetById(tweetId);
			return "Tweet with TweetId: "+tweetId+" Successfully Deleted!";
		}
		return "Delete Tweet After Login!";
	}
	
	@PutMapping("/twitter/user/{userName}/tweet/{tweetId}")
	public String updateTweet(@PathVariable String userName, @PathVariable int tweetId, @RequestBody Tweet tweetDetails) {
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			Tweet tweet = tweetService.retrieveTweetsByTweetId(tweetId);
			tweet.setTweet(tweetDetails.getTweet());
			tweetService.addOrUpdateTweet(tweet);
			return "Tweet Successfully Updated!";
		}
		
		return "Update Tweet After Login";
	}
	
	@GetMapping("/twitter/trending")
	public List<String> trendingTweets(){
		return tweetService.trendingTweets();
	}
	
}
