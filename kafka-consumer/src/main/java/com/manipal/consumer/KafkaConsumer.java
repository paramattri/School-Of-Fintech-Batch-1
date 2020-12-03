package com.manipal.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "info_topic", groupId = "anything")
	public void consume(String info) {
		System.out.println("Info received: "+info);
	}
	
	@KafkaListener(topics = "book_topic", groupId = "bookListen")
	public void consumeBookObject(Object book) {
		System.out.println("Book received: "+book);
	}
}
