package com.manipal.mocking.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manipal.mocking.service.ToDoService;

public class ToDoBusinessAnnotationTest {
	
	@Mock
	private ToDoService toDoService; // Mocking Using Annotations
	
	@InjectMocks
	private ToDoBusiness toDoBusiness;
	
	@Test
	void testGetTodosForSpring() {
		
		MockitoAnnotations.initMocks(this);
		List<String> toDoList = Arrays.asList("Spring Core", "Java", "Spring Boot", "Kotlin"); //dummyList
		when(toDoService.getTodos()).thenReturn(toDoList);
		
		List<String> finalToDos = toDoBusiness.getTodosForSpring();
		
		assertEquals(2, finalToDos.size());
		verify(toDoService, times(1)).getTodos();
		verify(toDoService, atLeastOnce()).getTodos();
		verify(toDoService, atLeast(1)).getTodos();
		verify(toDoService, atMost(1)).getTodos();
		verify(toDoService, never()).neverUsed();
	}

}
