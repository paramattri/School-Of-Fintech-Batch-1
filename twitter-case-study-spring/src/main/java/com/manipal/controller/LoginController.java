package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.manipal.model.Login;
import com.manipal.service.LoginService;
import com.manipal.util.CurrentUserNameUtil;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/twitter/login")
	public String login(@RequestBody Login login) {
	
		boolean isValidated = loginService.loginValidation(login);
		if(isValidated) {
			CurrentUserNameUtil.setCurrentUserName(login.getUserName());
			return "Login Successfully! \n\nWelcome "+CurrentUserNameUtil.getCurrentUserName();
		}
		else
			return "Check UserName Or Password!";
	}
	
	
}
