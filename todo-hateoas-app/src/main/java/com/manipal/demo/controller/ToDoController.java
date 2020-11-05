package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public CollectionModel<ToDo> retrieveAllTodos(){
		List<ToDo> toDos = toDoService.getAllTodos();
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(ToDoController.class).retrieveAllTodos());
		CollectionModel collectionModel = CollectionModel.of(toDos);
		collectionModel.add(linkBuilder.withSelfRel());
		
		return collectionModel;
	}
	
	@GetMapping("/todos/{id}")
	public EntityModel retrieveTodo(@PathVariable Integer id){
		ToDo toDo = toDoService.getToDo(id);
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(ToDoController.class).retrieveAllTodos());
		WebMvcLinkBuilder linkBuilder1 = linkTo(methodOn(ToDoController.class).retrieveTodo(id));
		EntityModel entityModel = EntityModel.of(toDo);
		entityModel.add(linkBuilder.withRel("all-todos"));
		entityModel.add(linkBuilder1.withSelfRel());
		
		return entityModel;
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
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable int id, @RequestBody ToDo toDoDetails) {
		ToDo toDo = toDoService.getToDo(id);
		toDo.setUserName(toDoDetails.getUserName());
		toDo.setDescription(toDoDetails.getDescription());
		toDo.setEndDate(toDoDetails.getEndDate());
		toDo.setIscompleted(toDoDetails.isIscompleted());
		
		ToDo toDoUpdated = toDoService.addToDo(toDo);
		
		//return ResponseEntity.accepted().headers(headers).body(todo);
		//return new ResponseEntity(todo,headers,HttpStatus.OK);
		return ResponseEntity.ok(toDoUpdated);
	}
	
	@DeleteMapping("/todos/{id}")
	public String deleteToDo(@PathVariable Integer id) {
		ToDo toDo = toDoService.getToDo(id);
		toDoService.deleteToDo(id);
		return "Record Deleted";
	}
	
	@GetMapping("/todos/completed")
	public List<ToDo> getAllCompletedToDos(){
		return toDoService.getCompletedToDos();
	}
	
}
