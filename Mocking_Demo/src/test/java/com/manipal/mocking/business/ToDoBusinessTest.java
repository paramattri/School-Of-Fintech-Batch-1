package com.manipal.mocking.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.manipal.mocking.service.ToDoService;

class ToDoBusinessTest {

	@Test
	void testGetTodosForSpring() {
		
		ToDoService toDoService = mock(ToDoService.class); //using mock method
		List<String> toDoList = Arrays.asList("Spring Core", "Java", "Spring Boot", "Kotlin"); //dummyList
		when(toDoService.getTodos()).thenReturn(toDoList);
		
		ToDoBusiness toDoBusiness = new ToDoBusiness(toDoService);
		List<String> finalToDos = toDoBusiness.getTodosForSpring();
		
		assertEquals(2, finalToDos.size());
		verify(toDoService, times(1)).getTodos();
		verify(toDoService, atLeastOnce()).getTodos();
		verify(toDoService, atLeast(1)).getTodos();
		verify(toDoService, atMost(1)).getTodos();
		verify(toDoService, never()).neverUsed();
	}

}
