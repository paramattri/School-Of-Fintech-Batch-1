package com.manipal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Book;

@RestController
public class BookResource {
	
	@Autowired
	private KafkaTemplate<String, Book> kafkaTemplate;
	
	private String topicBook = "book_topic";
	
	@GetMapping("/book/{id}")
	public String publish(@PathVariable Integer id) {
		kafkaTemplate.send(topicBook, new Book(id, "Java Next", 499.00, "Ram"));
		return "Book Information is published into topic successfully!";
	}
}
