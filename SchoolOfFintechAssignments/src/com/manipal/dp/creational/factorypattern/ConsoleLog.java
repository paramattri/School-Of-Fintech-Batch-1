package com.manipal.dp.creational.factorypattern;

public class ConsoleLog implements Logger {

	@Override
	public void getMessage() {
		System.out.println("Log Message is displayed in Console");
	}

}
