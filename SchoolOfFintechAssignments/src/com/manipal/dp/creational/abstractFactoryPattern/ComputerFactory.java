package com.manipal.dp.creational.abstractFactoryPattern;

public class ComputerFactory extends AbstractDeviceFactory{

	@Override
	public Computer getComputer(String electronicType) {
		
		if(electronicType.equals("Personal Computer"))
			return new PersonalComputer();
		
		if(electronicType.equals("Laptop"))
			return new Laptop();
		
		return null;
		
	}

	@Override
	public Mobile getMobile(String electronicType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
