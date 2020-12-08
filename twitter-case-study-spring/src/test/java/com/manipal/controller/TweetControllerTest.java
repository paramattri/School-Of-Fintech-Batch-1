//package com.manipal.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.manipal.model.Tweet;
//import com.manipal.service.TweetService;
//
//@WebMvcTest(TweetController.class)
//class TweetControllerTest {
//	
//	@Autowired
//	private MockMvc mvc;
//	
//	@MockBean
//	private TweetService tweetService;
//	
//	@Test
//	void testHomePage() throws Exception {		
//		mvc.perform(get("/twitter").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Welcome To Twitter Clone!!\nVisit different URLs for some fun. Enjoy!"));
//	}
//
//	@Test
//	void testAddTweet() throws JsonProcessingException, Exception {
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		Tweet tweet = new Tweet(1,"Pattri","#Diwali",LocalDateTime.now());
//		
//		mvc.perform(post("/twitter/user/Pattri/tweet")
//				.content(objectMapper.writeValueAsString(tweet))
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().is(400));
//		
//		verify(tweetService, times(0)).addOrUpdateTweet(tweet);
//	}
//
//	@Test
//	void testRetrieveTweetsByUserName() throws Exception {
//		
//		mvc.perform(get("/twitter/user/Pattri/tweets").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	void testRetrieveTweetsByTweetId() throws Exception {
//		
//		mvc.perform(get("/twitter/user/Pattri/tweetId/2").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	void testRetrieveAllTweets() throws Exception {
//		
//		mvc.perform(get("/twitter/tweets").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	void testDeleteTweetByTweetName() throws Exception {
//		
//		mvc.perform(delete("/twitter/user/Pattri/tweets/Diwali").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	void testDeleteTweetById() throws Exception {
//		
//		mvc.perform(delete("/twitter/user/Pattri/tweetId/10").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	void testUpdateTweet() throws JsonProcessingException, Exception {
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		Tweet tweet = new Tweet(1,"Pattri","#Diwali",LocalDateTime.now());
//		
//		mvc.perform(put("/twitter/user/Pattri/tweet/12")
//				.content(objectMapper.writeValueAsString(tweet))
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().is(400));
//	}
//
//	@Test
//	void testTrendingTweets() throws Exception {
//		
//		mvc.perform(get("/twitter/trending").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
//
//}
