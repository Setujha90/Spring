package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter Customer ID: ");
	        int customerId = sc.nextInt();

	        System.out.print("Enter Product ID: ");
	        int productId = sc.nextInt();

	        System.out.print("Enter Price: ");
	        double price = sc.nextDouble();
	        sc.nextLine();  // clear buffer

	        System.out.print("Enter Address: ");
	        String address = sc.nextLine();
	        
	        String insert = "INSERT INTO shop.order_details (CustomerId, ProductId, Price, Address) VALUES (?, ?, ?, ?)";
	        
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
			 	ps.setInt(1, customerId);
		        ps.setInt(2, productId);
		        ps.setDouble(3, price);
		        ps.setString(4, address);
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
