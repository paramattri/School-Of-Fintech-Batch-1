package day10Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductsDemo2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Code: ");
		int productCode = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productsdb", "root", "dashingteam");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE PROD_CODE = "+productCode);
			System.out.println("Product Details: ");
			while(resultSet.next()) {
				System.out.println("Code: "+resultSet.getInt(1)+"\nName: "+resultSet.getString(2)+"\nPrice: "+resultSet.getInt(3)+"\nCategory: "+resultSet.getString(4));
			}
			
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
