package day10Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

class Product{
	private int productCode;
	private String productName;
	private int productPrice;
	private String productCategory;
	
	public Product(int productCode, String productName, int productPrice, String productCategory) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
}

public class ProductsDemo3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productsdb", "root", "dashingteam");
			String sql = "INSERT INTO products VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			ArrayList<Product> products = new ArrayList<Product>();
			int update = 0;
			System.out.println("Enter The Number of Products: ");
			int noOfProducts = sc.nextInt();
			for(int i = 0; i < noOfProducts; i++) {
				System.out.println("Enter The Product Code: ");
				int productCode = sc.nextInt();
				System.out.println("Enter The Product Name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.println("Enter The Product Price: ");
				int productPrice  = sc.nextInt();
				System.out.println("Enter The Product Category: ");
				sc.nextLine();
				String productCategory = sc.nextLine();
				products.add(new Product(productCode, productName, productPrice, productCategory));
			}
			
			for(int i = 0; i < products.size(); i++) {
				statement.setInt(1, products.get(i).getProductCode());
				statement.setString(2, products.get(i).getProductName());
				statement.setInt(3, products.get(i).getProductPrice());
				statement.setString(4, products.get(i).getProductCategory());
				update += statement.executeUpdate();
			}
			
			System.out.println("All Products Inserted");
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
