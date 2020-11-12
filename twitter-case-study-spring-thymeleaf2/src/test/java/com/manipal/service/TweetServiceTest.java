package com.manipal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.model.Tweet;
import com.manipal.repository.TweetRepository;

@SpringBootTest
class TweetServiceTest {
	
	@Autowired 
	private TweetService tweetService;
	
	@MockBean
	private TweetRepository tweetRepository;
	
	@Test
	void testAddOrUpdateTweet() {
		Tweet tweet = new Tweet(1,"Pattri","#Diwali", LocalDateTime.now());
		tweetService.addOrUpdateTweet(tweet);
		verify(tweetRepository, times(1)).save(tweet);
	}

	@Test
	void testRetrieveTweetsByUserName() {
		Tweet tweet = new Tweet(1,"Pattri","#Diwali", LocalDateTime.now());
		Tweet tweet2 = new Tweet(2,"Pattri","#Holi", LocalDateTime.now());
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets.add(tweet);
		tweets.add(tweet2);
		
		when(tweetRepository.findByUserName("Pattri")).thenReturn(tweets);
		assertEquals(2, tweetService.retrieveTweetsByUserName("Pattri").size());			
	}

	@Test
	void testRetrieveTweetsByTweetId() {
		int tweetId = 10;
		Tweet tweet = new Tweet(10,"Pattri","#Diwali", LocalDateTime.now());
		when(tweetRepository.findById(tweetId)).thenReturn(Optional.of(tweet));
		assertEquals(tweet, tweetService.retrieveTweetsByTweetId(tweetId));
	}

	@Test
	void testRetrieveAllTweets() {
		
		String keyword = "Pattri";
		Tweet tweet = new Tweet(1,"Pattri","#Diwali", LocalDateTime.now());
		Tweet tweet2 = new Tweet(2,"Pattri","#Holi", LocalDateTime.now());
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets.add(tweet);
		tweets.add(tweet2);
		
		when(tweetRepository.search(keyword)).thenReturn(tweets);
		assertEquals(2, tweetService.retrieveAllTweets(keyword).size());
	}

	@Test
	void testDeleteTweetByTweetName() {
		Tweet tweet = new Tweet(1,"Pattri","#Diwali", LocalDateTime.now());
		tweetService.deleteTweetByTweetName(tweet.getTweet());
		verify(tweetRepository, times(1)).deleteByTweet(tweet.getTweet());
	}

	@Test
	void testDeleteTweetById() {
		Tweet tweet = new Tweet(1,"Pattri","#Diwali", LocalDateTime.now());
		tweetService.deleteTweetById(tweet.getTweetId());
		verify(tweetRepository, times(1)).deleteById(tweet.getTweetId());
	}
	
	@Test
	void testTrendingTweets() {
		tweetService.trendingTweets();
		verify(tweetRepository, times(1)).trendingTweets();
	}

}
