package com.manipal.mocking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.mocking.repository.ToDoRepository;

@Service
public class ToDoServiceSpring {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public List<String> getSpringToDos() {
		
		List<String> retrievedtodos = new ArrayList<String>(); 
		List<String> todos = toDoRepository.getTodos();
		
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				retrievedtodos.add(todo);
			}
		}
		
		return retrievedtodos;
	}

}
