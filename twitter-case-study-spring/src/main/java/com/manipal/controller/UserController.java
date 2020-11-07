package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.manipal.model.Login;
import com.manipal.model.User;
import com.manipal.service.LoginService;
import com.manipal.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	private String currentUser;
	
	@PostMapping("/twitter/register")
	public String registration(@RequestBody User user) {
		
		String registrationResponse = userService.registation(user);
		if(registrationResponse.equals("Thanks for Registering!")) {
			Login login = new Login();
			login.setUserName(user.getUserName());
			login.setPassword(user.getPassword());
			loginService.addLoginDetails(login);
			return registrationResponse;
		}
		
		return registrationResponse;
	}
	
//	@GetMapping("/twitter")
//	public RedirectView hello1(RedirectAttributes redirectAttrs) {
//		redirectAttrs.addAttribute("userName", "Param");
//		return new RedirectView("twitter/user/{userName}");
//	}
//	
//	@GetMapping("/twitter/user/{userName}")
//	public String hello(@PathVariable String userName) {
//		return "hello "+userName;
//	}
}
