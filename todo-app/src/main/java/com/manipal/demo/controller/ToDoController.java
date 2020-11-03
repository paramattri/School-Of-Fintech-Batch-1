package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.bean.ToDo;
import com.manipal.demo.service.ToDoService;

@RestController
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;
	
//	@GetMapping("/todos/users/{userName}")
//	public List<ToDo> retrieveTodos(@PathVariable String userName){
//		
//		return toDoService.retrieveToDos(userName);
//	}
	
//	@GetMapping("/todos")
//	public List<ToDo> retrieveAllTodos(){
//		return toDoService.retrieveAllToDos();
//	}
	
	@GetMapping("/todos")
	public List<ToDo> retrieveAllTodos(){
		return toDoService.getAllTodos();
	}
	
	@GetMapping("/todos/{id}")
	public ToDo retrieveTodo(@PathVariable Integer id){
		return toDoService.getToDo(id);
	}
	
//	@PostMapping("/todos")
//	public ToDo addToDo(@RequestBody ToDo toDo) {
//		return toDoService.addToDo(toDo);
//	}
	
	@PostMapping("/todos")
	public ResponseEntity<ToDo> addToDo(@RequestBody ToDo toDo) {
		ToDo todo = toDoService.addToDo(toDo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Response-from", "ToDoController");
		//return ResponseEntity.accepted().headers(headers).body(todo);
		return new ResponseEntity(todo,headers,HttpStatus.OK);
	}
	
	

}
