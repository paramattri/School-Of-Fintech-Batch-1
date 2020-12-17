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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.mocking.repository.ToDoRepository;
import com.manipal.mocking.service.ToDoServiceSpring;

@SpringBootTest
class ToDoBusinessSpringTest {
	
	@Autowired
	private ToDoServiceSpring toDoServiceSpring;
	
	@MockBean
	private ToDoRepository toDoRepository;
	
	@Test
	void testGetTodosForSpring() {
		
		List<String> toDoList = Arrays.asList("Spring Core", "Java", "Spring Boot", "Kotlin");
		when(toDoRepository.getTodos()).thenReturn(toDoList);
		
		List<String> finalToDos = toDoServiceSpring.getSpringToDos();
		assertEquals(2, finalToDos.size());
		verify(toDoRepository, times(1)).getTodos();
		verify(toDoRepository, atLeastOnce()).getTodos();
		verify(toDoRepository, atLeast(1)).getTodos();
		verify(toDoRepository, atMost(1)).getTodos();
		verify(toDoRepository, never()).neverUsed();
		
	}

}
