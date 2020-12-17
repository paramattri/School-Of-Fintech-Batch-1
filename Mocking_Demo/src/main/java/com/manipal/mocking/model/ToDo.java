package com.manipal.mocking.model;

import java.beans.JavaBean;

@JavaBean
public class ToDo {
	
	private String toDoName;

	public ToDo() {}
	
	public ToDo(String toDoName) {
		super();
		this.toDoName = toDoName;
	}

	public String getToDoName() {
		return toDoName;
	}

	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}
	
}
