package com.manipal.dp.creational.factorypattern;

public class LoggerFactory {
	
	public Logger getLogger(String type) {
		
		if(type.equals("file"))
			return new FileLog();
		
		if(type.equals("database"))
			return new DatabaseLog();
		
		if(type.equals("console"))
			return new ConsoleLog();
		
		return null;
	}

}
