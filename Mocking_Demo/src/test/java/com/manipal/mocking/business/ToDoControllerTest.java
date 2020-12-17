package com.manipal.mocking.business;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.manipal.mocking.controller.ToDoController;
import com.manipal.mocking.service.ToDoServiceSpring;

@WebMvcTest(ToDoController.class)
class ToDoControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ToDoServiceSpring toDoServiceSpring;
	
	@Test
	void testGetSpringToDos() throws Exception {
		
		mvc.perform(get("/todos").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
