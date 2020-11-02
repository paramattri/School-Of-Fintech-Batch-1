package com.manipal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView welcomeAll() {
		String message = "Hi All, Welcome to the Spring MVC Application.";
		ModelAndView modelAndView = new ModelAndView("welcome", "welcomeModel", message);
		return modelAndView;
	}
	
	@RequestMapping("/greet")
	public String greet(Model model) {
		String userName = "Ram";
		model.addAttribute("user", userName);
		return "greet-user";
		
	}
	
	@RequestMapping("/userForm")
	public String getForm() {
		return "userForm";
	}
	
	@RequestMapping("/addUser")
	public String addUserDetails(@RequestParam String userName, @RequestParam String userLocation, Model model) {
		model.addAttribute("userName",userName);
		model.addAttribute("userLocation",userLocation);
		return "userDetails";
	}

}
