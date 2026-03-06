package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StepsOfJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Load the driver Class
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String name = scanner.next();
		
		System.out.println("Enter Employee Mobile Number");
		 Long mobile_number = scanner.nextLong();
		 
		System.out.println("Enter Employee Department Number");
		int deptno = scanner.nextInt();
		
		System.out.println("Enter Employee Salary");
		Double salary = scanner.nextDouble();
		
		String insert  =  "insert into iem.employee_details (emp_name,emp_mobile_number,emp_deptno,emp_salary) values (?,?,?,?)";
		
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
		preparedStatement.setLong(2, mobile_number);
		preparedStatement.setInt(3, deptno);
		preparedStatement.setDouble(4, salary);
		
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
