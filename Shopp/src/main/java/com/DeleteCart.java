package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Cart ID: ");
        int cartId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();
        
        String insert = "DELETE FROM shop.cart_details WHERE Cart_ID = ? AND Productid = ?";
        
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
		ps.setInt(1, cartId);
        ps.setInt(2, productId);
        System.out.println("After setting the values "+ps);

		
		System.out.println("Platform Created ....");
		
		//4. Execute query
		int result = ps.executeUpdate();
		if(result!=0) {
			System.out.println("Cart record deleted successfully...");
		}
		else {
			System.out.println("No matching record found");
		}
		
//		System.out.println(preparedStatement.executeUpdate());
		
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
