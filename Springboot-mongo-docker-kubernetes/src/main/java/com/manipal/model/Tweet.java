package com.manipal.model;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tweets")
public class Tweet {
	
	@Transient
	public static final String SEQUENCE_NAME = "tweets_sequence";
	
	@Id
	private int tweetId;
	private String username;
	private String tweetBody;
	private LocalDateTime tweetCreationTime;
	
	public Tweet() {}

	public Tweet(int tweetId, String username, String tweetBody, LocalDateTime tweetCreationTime) {
		super();
		this.tweetId = tweetId;
		this.username = username;
		this.tweetBody = tweetBody;
		this.tweetCreationTime = tweetCreationTime;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public LocalDateTime getTweetCreationTime() {
		return tweetCreationTime;
	}

	public void setTweetCreationTime(LocalDateTime tweetCreationTime) {
		this.tweetCreationTime = tweetCreationTime;
	}
	
}
