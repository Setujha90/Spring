package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentPerGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String select = "select * from student_details where Student_Percentage>80";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
		
		PreparedStatement ps = connections.prepareStatement(select);
		
		ResultSet resultSet=ps.executeQuery();
//		System.out.println(resultSet);
		
		boolean flag = true;
		while(resultSet.next()) {
			flag=false;
			System.out.println("Data Existed");
			System.out.println("STUDENT NAME: "+resultSet.getString("Student_Name"));
			System.out.println("STUDENT PERCENTAGE: "+resultSet.getDouble("Student_Percentage"));
			System.out.println("STUDENT STREAM: "+resultSet.getString("Student_Stream"));
			System.out.println("STUDENT DEGREE: "+resultSet.getString("Student_Degree"));
			System.out.println("STUDENT EMAIL: "+resultSet.getString("Student_Email"));
			System.out.println("STUDENT GENDER: "+resultSet.getString("Student_Gender"));
			System.out.println("STUDENT DOB: "+resultSet.getDate("Student_D_O_B"));
			System.out.println("STUDENT MOBILE NUMBER: "+resultSet.getLong("Student_Mobile_Number"));
			
		}
		
		if(flag) {
			System.out.println("Data is not existed for particular query");
		}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
