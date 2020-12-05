package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@Autowired
	 SimpMessagingTemplate template;
	
	@KafkaListener(topics = "twitter-test", groupId = "twitter-test-data")
	public void consume(String tweet) {
		System.out.println("Sending via Kafka Consumer..");
		template.convertAndSend("/topic/pushTweets", tweet);
		//System.out.println("Tweet received: "+tweet);
	}
}
