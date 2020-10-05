package day5Assignment1;

class Product2{
	
	String productCode;
	String productName;
	double productPrice;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}

public class Question2TestProduct {

	public static void main(String[] args) {
		
		Product2 p = new Product2();
		
		p.setProductCode("P101");
		p.setProductName("Laptop");
		p.setProductPrice(45000);

		System.out.println("Product Code: "+ p.getProductCode());
		System.out.println("Product Name: "+ p.getProductName());
		System.out.println("Product Price: "+ p.getProductPrice());

	}

}
