package com.manipal.dp.creational.abstractFactoryPattern;

public abstract class AbstractDeviceFactory {
	
	public abstract Computer getComputer(String electronicType);
	public abstract Mobile getMobile(String electronicType);
	
}
