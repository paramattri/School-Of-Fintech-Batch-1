package com.manipal.mocking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository {
	
	public List<String> getTodos();
	public String neverUsed();
}
