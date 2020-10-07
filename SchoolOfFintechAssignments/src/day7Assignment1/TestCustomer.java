package day7Assignment1;

import java.util.Scanner;

class InvalidInputException extends Exception{
	/*public InvalidInputException() {
		System.out.println("Enter the correct details..");
	}*/
}

class Customer{
	private String custNo;
	private String custName;
	private String category;
	public Customer(String custNo, String custName, String category) throws InvalidInputException {
		super();
		this.custNo = custNo;
		this.custName = custName;
		this.category = category;
		
		if(!(custNo.charAt(0) == 'C' || custNo.charAt(0) == 'c' )) {
			throw new InvalidInputException();
		}
		if(!(custName.length() == 4))
			throw new InvalidInputException();
		if(!(category.equals("Platinum") || category.equals("Gold") || category.equals("Silver")))
			throw new InvalidInputException();
	}
	
	public String getCustNo() {
		return custNo;
	}
	public String getCustName() {
		return custName;
	}
	public String getCategory() {
		return category;
	}
	
}

public class TestCustomer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String custNo = sc.nextLine();
		String custName = sc.nextLine();
		String category = sc.nextLine();
		
		try {
			Customer c = new Customer(custNo, custName, category);
			System.out.println("Customer Number: "+c.getCustNo()+" Customer Name: "+c.getCustName()+" Category: "+c.getCategory());
		}
		catch(InvalidInputException e) {
			System.out.println("Enter Correct Details!!");
		}
		

	}

}
