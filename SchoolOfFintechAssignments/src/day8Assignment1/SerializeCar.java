package day8Assignment1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCar implements Serializable{

	public static void main(String[] args) {
		
		Engine e = new Engine();
		e.setEngineNo("E123");
		e.setCubicCapacity(20);
		
		Car c = new Car();
		c.setRegistrationNo("R1000");
		c.setCarMake("Hyundai");
		c.setEngine(e);
		
		try {
			FileOutputStream fos = new FileOutputStream("Cardata.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

	}

}
