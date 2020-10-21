package com.manipal.dp.creational.abstractFactoryPattern;

public class Client {

	public static void main(String[] args) {
		
		AbstractDeviceFactory electronicFactory = DeviceFactoryProducer.getElectronicFactory("Computer");
		Computer personalComputer = electronicFactory.getComputer("Personal Computer");
		personalComputer.getMessage();
		
		electronicFactory = DeviceFactoryProducer.getElectronicFactory("Computer");
		Computer laptop = electronicFactory.getComputer("Laptop");
		laptop.getMessage();
		
		electronicFactory = DeviceFactoryProducer.getElectronicFactory("Mobile");
		Mobile cellPhone = electronicFactory.getMobile("Cell Phone");
		cellPhone.getMessage();
		
		electronicFactory = DeviceFactoryProducer.getElectronicFactory("Mobile");
		Mobile smartPhone = electronicFactory.getMobile("Smart Phone");
		smartPhone.getMessage();
		
		

	}

}
