package com.manipal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manipal.model.User;
import com.manipal.service.LoginService;
import com.manipal.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private LoginService loginService;

	@Test
	void testRegistration() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User("Param","Attri","Pattri","qwerty","attri.param@gmail.com");
		
		mvc.perform(post("/twitter/register")
				.content(objectMapper.writeValueAsString(user))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		when(userService.registation(user)).thenReturn("Thanks for Registering!");
	}

}
