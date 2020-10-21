package com.manipal.dp.creational.abstractFactoryPattern;

public class MobileFactory extends AbstractDeviceFactory {

	@Override
	public Computer getComputer(String electronicType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mobile getMobile(String electronicType) {
		
		if(electronicType.equals("Cell Phone"))
			return new CellPhone();
		
		if(electronicType.equals("Smart Phone"))
			return new SmartPhone();
		
		return null;
	}
		
	
}
