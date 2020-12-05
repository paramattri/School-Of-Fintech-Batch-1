package com.manipal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfiguration {
	
	@Bean
	public Twitter twitterInstance() {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("")
		.setOAuthConsumerSecret("")
		.setOAuthAccessToken("")
		.setOAuthAccessTokenSecret("");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		System.out.println("Configgggg Data");
		return tf.getInstance();
	}
	
	@Bean
	public TwitterStream twitterStreamInstance() {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("")
		.setOAuthConsumerSecret("")
		.setOAuthAccessToken("")
		.setOAuthAccessTokenSecret("");
		
		TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
		System.out.println("Stream Config Done");
		return tsf.getInstance();
		
	}
	
}
