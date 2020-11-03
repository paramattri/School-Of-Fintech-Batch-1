package day10Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDemo4 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productsdb", "root", "dashingteam");
			Statement statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery("SELECT * FROM PRODUCTS");
			//System.out.println("Product Details: ");
			String sql = "UPDATE PRODUCTS SET PROD_PRICE = ?";
			PreparedStatement statement2 = connection.prepareStatement(sql);
			int updatedPrice = 0;
			ResultSetMetaData rsMetaData = resultSet.getMetaData();
			int updations = 0;
			while(resultSet.next()) {
				if(resultSet.getString(4).equals("Electronics") && resultSet.getInt(3) < 1000) {
					updatedPrice = (int) (resultSet.getInt(3) + 0.10 * resultSet.getInt(3));
				}
				else if(resultSet.getString(4).equals("Clothing") && resultSet.getInt(3) > 1000) {
					updatedPrice = (int) (resultSet.getInt(3) - 0.10 * resultSet.getInt(3));
				}
				else
					updatedPrice = resultSet.getInt(3);
				
				statement2.setInt(1, updatedPrice);
				updations += statement2.executeUpdate();
				System.out.println("Updations: "+updations);
				//System.out.println("Code: "+resultSet.getInt(1)+"\nName: "+resultSet.getString(2)+"\nPrice: "+resultSet.getInt(3)+"\nCategory: "+resultSet.getString(4));
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
