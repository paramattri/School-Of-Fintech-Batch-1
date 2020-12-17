package com.manipal.mocking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.mocking.service.ToDoServiceSpring;

@RestController
public class ToDoController {
	
	@Autowired
	private ToDoServiceSpring toDoServiceSpring;
	
	@GetMapping("/todos")
	public List<String> getSpringToDos(){
		return toDoServiceSpring.getSpringToDos(); 
	}
}
