package com.manipal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/twitter")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/twitter/registration")
	public String showRegistrationForm(User user, Model model) {
		return "register-form";
	}
	
	@PostMapping("/twitter/register")
	public String registration(@Valid User user, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
            return "register-form";
        }
		
		userService.registation(user);
		Login login = new Login();
		login.setUserName(user.getUserName());
		login.setPassword(user.getPassword());
		loginService.addLoginDetails(login);
		
		return "redirect:/twitter/login";
	}
}