package com.manipal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manipal.model.Tweet;
import com.manipal.service.TweetService;

@WebMvcTest(TweetController.class)
class TweetControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TweetService tweetService;
	
	@MockBean
	private Tweet tweet;
	
	@Test
	void testAddTweetGet() throws Exception {
		
		mvc.perform(get("/twitter/user/Pattri/tweet").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testAddTweetPost() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Tweet tweetOb = new Tweet(1,"Pattri","#Diwali",LocalDateTime.now());
		
		mvc.perform(post("/twitter/user/Pattri/tweet")
				.content(objectMapper.writeValueAsString(tweetOb))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
//		when(tweet.getTweet()).thenReturn("#Diwali");
//		when(tweet.getTweet().length()).thenReturn(1);
//		verify(tweet, times(1)).getTweet();
	}

	@Test
	void testRetrieveTweetsByUserName() throws Exception {
		
		mvc.perform(get("/twitter/user/Pattri/tweets").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testRetrieveAllTweets() throws Exception {
		
		mvc.perform(get("/twitter/tweets").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testDeleteTweetById() throws Exception {
		
		mvc.perform(get("/twitter/user/Pattri/tweetId/10").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is(302));
	}

	@Test
	void testUpdateTweetStringIntModel() throws Exception {
		
		mvc.perform(get("/twitter/user/Pattri/tweet/12").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

//	@Test
//	void testUpdateTweetStringIntTweetBindingResultRedirectAttributes() throws JsonProcessingException, Exception {
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		Tweet tweet = new Tweet(1,"Pattri","#Diwali",LocalDateTime.now());
//		
//		mvc.perform(post("/twitter/user/Pattri/tweet/12")
//				.content(objectMapper.writeValueAsString(tweet))
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}

	@Test
	void testTrendingTweets() throws Exception {
		
		mvc.perform(get("/twitter/trending").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
