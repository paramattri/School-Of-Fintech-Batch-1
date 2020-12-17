package com.manipal.mocking.business;

import java.util.ArrayList;
import java.util.List;

import com.manipal.mocking.service.ToDoService;

public class ToDoBusiness {
	
	private ToDoService toDoService;
	
	public ToDoBusiness() {}
	
	public ToDoBusiness(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	public List<String> getTodosForSpring(){
		
		List<String> retrievedtodos = new ArrayList<String>(); 
		List<String> todos = toDoService.getTodos();
		
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				retrievedtodos.add(todo);
			}
		}
		
		return retrievedtodos;
	}
}
