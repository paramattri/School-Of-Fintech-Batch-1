package com.manipal.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.WelcomeBean;

@RestController
public class GreetingController {
	
	//@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@GetMapping("/welcome")
	public String Welcome() {
		
		return "Hi, How are you?";
	}
	
	@GetMapping("/welcome/{name}")
	public String WelcomeWithName(@PathVariable String name) {
		
		return "Hi "+name+" , How are you?";
	}
	
	@GetMapping("/welcome/{userName}/{location}")
	public String WelcomeWithNameAndLocation(@PathVariable("userName") String name, @PathVariable String location) {
		
		return "Hi "+name+" , How is "+location;
	}
	
	@GetMapping("/welcomeobj")
	public WelcomeBean WelcomeWithObject() {
		
		return new WelcomeBean("Hi, How are you?");
	}
}
