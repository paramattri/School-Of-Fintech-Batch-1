package com.manipal.dp.creational.factorypattern;

public class DatabaseLog implements Logger{
	
	@Override
	public void getMessage() {
		System.out.println("Log Message is displayed in Database");
	}

}
