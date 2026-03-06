package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetailsInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name");
		String name = scanner.next();
		
		System.out.println("Enter Student Percentage");
		 Double percentage = scanner.nextDouble();
		 
		System.out.println("Enter Student Stream");
		String stream = scanner.next();
		
		System.out.println("Enter Student Degree");
		String degree = scanner.next();
		
		System.out.println("Enter Student Email");
		String email = scanner.next();
		
		System.out.println("Enter Student gender");
		String gender = scanner.next();
		
		System.out.println("Enter Student DOB");
		String dob = scanner.next();
		
		System.out.println("Enter Student Mobile Number");
		Long mobile_number = scanner.nextLong();
		
		String insert  =  "insert into student_management_system.student_details (Student_Name, Student_Percentage, Student_Stream, Student_Degree, Student_Email, Student_Gender, Student_D_O_B, Student_Mobile_Number) values (?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded Successfully");
			
			//2. Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection successfully");
			
			//3.create platform
		PreparedStatement preparedStatement =  connection.prepareStatement(insert);
		System.out.println("Before setting the value "+preparedStatement);
		
		//Making the query as complete query
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, percentage);
		preparedStatement.setString(3,stream );
		preparedStatement.setString(4,degree );
		preparedStatement.setString(5,email );
		preparedStatement.setString(6,gender );
		preparedStatement.setDate(7,Date.valueOf(dob));
		preparedStatement.setLong(8, mobile_number);
		
		System.out.println("After setting the values "+preparedStatement);

		
		System.out.println("Platform Created ....");
		
		//4. Execute query
		int result = preparedStatement.executeUpdate();
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
