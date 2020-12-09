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
		.setOAuthConsumerKey("0EfKWPDGmiYFVoP5UBtdoeud7")
		.setOAuthConsumerSecret("j8JKvtnoS3un3hfTPS9v9J7KevKRBAc5S9Onk3cdZD9YacqGc9")
		.setOAuthAccessToken("1238039225070567426-AUk0VgFZ7PxxDMxuyrlscSUqTOgdhr")
		.setOAuthAccessTokenSecret("ADlsZWWoUKXTIQynhNRQEbL2nFQw9yxAHRPINqdesQFs8");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		System.out.println("Configgggg Data");
		return tf.getInstance();
	}
	
	@Bean
	public TwitterStream twitterStreamInstance() {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("0EfKWPDGmiYFVoP5UBtdoeud7")
		.setOAuthConsumerSecret("j8JKvtnoS3un3hfTPS9v9J7KevKRBAc5S9Onk3cdZD9YacqGc9")
		.setOAuthAccessToken("1238039225070567426-AUk0VgFZ7PxxDMxuyrlscSUqTOgdhr")
		.setOAuthAccessTokenSecret("ADlsZWWoUKXTIQynhNRQEbL2nFQw9yxAHRPINqdesQFs8");
		
		TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
		System.out.println("Stream Config Done");
		return tsf.getInstance();
		
	}
	
}
