package day5Assignment1;

class Product4{
	
	private String productCode;
	private String productName;
	private double productPrice;
	private char categoryCode;
	
	private static int prodCounter = 100;
	
	public Product4(String productName, int productPrice, char categoryCode) {
		
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryCode = categoryCode;
		productCode = generateProductCode();
		
	}
	
	public Product4(String productName, int productPrice) {
		
		this.productName = productName;
		this.productPrice = productPrice;
		categoryCode = 'E';
		productCode = generateProductCode();
		
	}
	
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

	public char getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(char categoryCode) {
		this.categoryCode = categoryCode;
	}

	public static int getProdCounter() {
		return prodCounter;
	}

	public static void setProdCounter(int prodCounter) {
		Product4.prodCounter = prodCounter;
	}
	
	private String generateProductCode(){
		String code = ""+categoryCode+prodCounter;
		prodCounter++;
		return code;
		
	}
	
	public String getProductDetails() {
		return "Product: Code - "+productCode+", Name - "+productName+", Price - "+productPrice+", Category - "+categoryCode;
	}
	
}

public class Question5TestProduct {

	public static void main(String[] args) {
		
		Product4 p = new Product4("Laptop",45000,'A');
		System.out.println(p.getProductDetails());
		Product4 p1 = new Product4("Laptop",45000);
		System.out.println(p1.getProductDetails());
	}

}
