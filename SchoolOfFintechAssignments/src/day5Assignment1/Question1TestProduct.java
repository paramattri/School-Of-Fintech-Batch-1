package day5Assignment1;

class Product{
	
	String productCode;
	String productName;
	double productPrice;
	
}

public class Question1TestProduct {

	public static void main(String[] args) {
		
		Product p = new Product();
		System.out.println("Product Code: "+ p.productCode);
		System.out.println("Product Name: "+ p.productName);
		System.out.println("Product Price: "+ p.productPrice);
		
		Product p1 = new Product();
		p1.productCode = "P101";
		p1.productName = "Laptop";
		p1.productPrice = 45000;
		
		System.out.println("Product Code: "+ p1.productCode);
		System.out.println("Product Name: "+ p1.productName);
		System.out.println("Product Price: "+ p1.productPrice);
		
				
	}

}
