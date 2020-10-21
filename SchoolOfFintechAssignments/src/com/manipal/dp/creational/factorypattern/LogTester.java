package com.manipal.dp.creational.factorypattern;

public class LogTester {

	public static void main(String[] args) {
		
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger = loggerFactory.getLogger("file");
		
		if(logger != null)
			logger.getMessage();
		
		logger = loggerFactory.getLogger("database");
		if(logger != null)
			logger.getMessage();
		
		logger = loggerFactory.getLogger("console");
		if(logger != null)
			logger.getMessage();

	}

}
