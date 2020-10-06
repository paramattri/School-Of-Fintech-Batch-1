package day6Assignment1;

abstract class Medicine{
	
	double price;
	String expiryDate;
	
	public void getDetails() {
		System.out.println("Price: "+price+" Expiry Date: "+expiryDate);
	}
	
	public abstract void displayLabel();
}

class Tablet extends Medicine{

	@Override
	public void displayLabel() {
		System.out.println("Store in a cool dry place");
	}	
}

class Syrup extends Medicine{
	@Override
	public void displayLabel() {
		System.out.println("Drink before expiry");
	}
}

class Ointment extends Medicine{
	public void displayLabel() {
		System.out.println("For external use only");
	}
}

public class TestMedicine {

	public static void main(String[] args) {
		
		Medicine[] m = new Medicine[5];
		
		int random = (int)(Math.random() * (3 - 1)) + 1;
		Medicine medi;
		
		if(random == 1) {
			medi = new Tablet();
			medi.price = 100;
			medi.expiryDate = "10 October 2020";
			medi.getDetails();
			medi.displayLabel();
			
		}else if(random == 2) {
			medi = new Syrup();
			medi.price = 500;
			medi.expiryDate = "20 October 2020";
			medi.getDetails();
			medi.displayLabel();
		}else {
			medi = new Ointment();
			medi.price = 1000;
			medi.expiryDate = "25 October 2020";
			medi.getDetails();
			medi.displayLabel();
		}
		

	}

}
