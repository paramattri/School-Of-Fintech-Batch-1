package com.manipal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manipal.model.Login;
import com.manipal.service.LoginService;
import com.manipal.util.CurrentUserNameUtil;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/twitter/login")
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login-form";
	}
	
	@PostMapping("/twitter/login")
	public String login(@Valid Login login, BindingResult result, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
            return "login-form";
        }
		
		boolean isValidated = loginService.loginValidation(login);
		if(isValidated) {
			CurrentUserNameUtil.setCurrentUserName(login.getUserName());
			redirectAttrs.addAttribute("userName", CurrentUserNameUtil.getCurrentUserName());
			return "redirect:/twitter/user/{userName}";
		}
		else
			return "login-form";
	}
	
	@GetMapping("/twitter/user/{userName}")
	public String userHomePage(@PathVariable String userName, Model model) {
		model.addAttribute("userName", userName);
		return "user-home";
	}
	
	@GetMapping("/twitter/logout")
	public String logout() {
		return "logout";
	}	
}
