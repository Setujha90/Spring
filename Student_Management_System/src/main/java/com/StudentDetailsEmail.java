package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetailsEmail {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of student");
		String email = sc.next();
        String select = "select * from student_details where Student_Email=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
		
		PreparedStatement ps = connections.prepareStatement(select);
		ps.setString(1, email);
		
		ResultSet resultSet=ps.executeQuery();
//		System.out.println(resultSet);
		
		if(resultSet.isBeforeFirst()) { //isBeforeFirst check whether the data is existed or not
			while(resultSet.next()) { // checking where(at which record) the cursor is pointing in the buffer memory
				
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
		}
		else {
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
