package com.manipal.dp.creational.abstractFactoryPattern;

public class DeviceFactoryProducer {
	
	public static AbstractDeviceFactory getElectronicFactory(String factoryName) {
		
		if(factoryName.equals("Computer"))
			return new ComputerFactory();
		
		if(factoryName.equals("Mobile"))
			return new MobileFactory();
		
		return null;
	}

}
