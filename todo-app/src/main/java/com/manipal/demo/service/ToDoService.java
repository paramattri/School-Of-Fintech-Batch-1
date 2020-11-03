package com.manipal.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.bean.ToDo;
import com.manipal.demo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
//	private static List<ToDo> todos = new ArrayList<ToDo>();
//	
//	static {
//		ToDo toDo1 = new ToDo(1, "Ram", "Learning Spring Boot", LocalDate.now(), false);
//		ToDo toDo2 = new ToDo(2, "Shyam", "Learning Spring Boot", LocalDate.now(), false);
//		ToDo toDo3 = new ToDo(3, "Shyam", "Learning Agile", LocalDate.now(), false);
//		ToDo toDo4 = new ToDo(4, "Ram", "Learning Spring REST", LocalDate.now(), false);
//		ToDo toDo5 = new ToDo(5, "Uma", "Learning Spring Boot", LocalDate.now(), true);
//		
//		todos.add(toDo1);
//		todos.add(toDo2);
//		todos.add(toDo3);
//		todos.add(toDo4);
//		todos.add(toDo5);
//	}
	
//	public List<ToDo> retrieveToDos(String userName){
//		List<ToDo> userToDoList = new ArrayList<>();
//		for(ToDo todo : todos) {
//			if(todo.getUserName().equals(userName))
//				userToDoList.add(todo);
//		}
//		
//		return userToDoList;
//	}
	
//	public List<ToDo> retrieveAllToDos(){
//		return todos;
//	}
	
	public List<ToDo> getAllTodos(){
		return toDoRepository.findAll();
	}
	
	public ToDo addToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
//		todos.add(toDo);
//		return toDo;
	}
	
	public ToDo getToDo(Integer id) {
		return toDoRepository.findById(id).orElse(null);
	}
}
