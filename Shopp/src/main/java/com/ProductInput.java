package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		  System.out.print("Enter Product Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Price: ");
	        double price = sc.nextDouble();

	        System.out.print("Enter Discount: ");
	        double discount = sc.nextDouble();
	        sc.nextLine();  // clear buffer

	        System.out.print("Enter Brand: ");
	        String brand = sc.nextLine();

	        System.out.print("Enter Category: ");
	        String category = sc.nextLine();

	        System.out.print("Enter Quantity: ");
	        int quantity = sc.nextInt();
	        
	        String insert = "INSERT INTO shop.product_details " +
	                "(Product_Name, Product_Price, Product_Discount, Brand, Category, Quantity) " +
	                "VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Class Loaded Successfully");
				
				//2. Establish the connection
			   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				System.out.println("Connection successfully");
				
				//3.create platform
			PreparedStatement ps =  connection.prepareStatement(insert);
			System.out.println("Before setting the value "+ps);
			
			//Making the query as complete query
			 ps.setString(1, name);
		        ps.setDouble(2, price);
		        ps.setDouble(3, discount);
		        ps.setString(4, brand);
		        ps.setString(5, category);
		        ps.setInt(6, quantity);
			
			System.out.println("After setting the values "+ps);

			
			System.out.println("Platform Created ....");
			
			//4. Execute query
			int result = ps.executeUpdate();
			if(result!=0) {
				System.out.println("Data inserted successfully...");
			}
			else {
				System.out.println("No data inserted");
			}
			
//			System.out.println(preparedStatement.executeUpdate());
			
			System.out.println("Execution completed....");
			
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
