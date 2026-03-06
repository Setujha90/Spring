package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        String insert = "INSERT INTO shop.customer_details " +
                "(Customer_Name, Customer_Emailid, Customer_Mobile_Number, Customer_Gender, Customer_Address, Password) " +
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
	        ps.setString(2, email);
	        ps.setString(3, mobile);
	        ps.setString(4, gender);
	        ps.setString(5, address);
	        ps.setString(6, password);
		
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
