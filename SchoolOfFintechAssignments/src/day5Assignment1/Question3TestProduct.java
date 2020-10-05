package day5Assignment1;

class Product3{
	
	private String productCode;
	private String productName;
	private double productPrice;
	
	public Product3(String productCode, String productName, double productPrice) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		
	}
	
	public void displayProductDetails() {
		
		System.out.println("Product Code: "+ productCode);
		System.out.println("Product Name: "+ productName);
		System.out.println("Product Price: "+ productPrice);
	}
}

public class Question3TestProduct {

	public static void main(String[] args) {
		
		Product3 p = new Product3("P101", "Laptop", 45000);
		p.displayProductDetails();

	}

}
