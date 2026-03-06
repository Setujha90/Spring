package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCustomerEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();
        
        String insert = "UPDATE shop.customer_details SET Customer_EmailId = ? WHERE Customer_Mobile_Number = ?";
        
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
		ps.setString(1, newEmail);
        ps.setString(2, mobile);
		System.out.println("After setting the values "+ps);

		
		System.out.println("Platform Created ....");
		
		//4. Execute query
		int result = ps.executeUpdate();
		if(result!=0) {
			System.out.println("Data update successfully...");
		}
		else {
			System.out.println("No data updated");
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
