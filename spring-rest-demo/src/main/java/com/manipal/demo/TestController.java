package com.manipal.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String homePage() {
		
		return "Welcome to Spring Boot Application";
	}
	
	@RequestMapping("/greet")
	public String greeting() {
		
		return "Good Afternoon!";
	}
}
