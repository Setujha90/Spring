package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchStudentByNameEmailGender {
	
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);

	        System.out.println("Search Student By:");
	        System.out.println("1. Name");
	        System.out.println("2. Email");
	        System.out.println("3. Gender");
	        System.out.println("4. Degree");

	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();
	        sc.nextLine();  

	        String column = "";
	        String value = "";

	        switch (choice) {

	            case 1:
	                column = "Student_Name";
	                System.out.print("Enter Student Name: ");
	                value = sc.nextLine();
	                break;

	            case 2:
	                column = "Student_Email";
	                System.out.print("Enter Student Email: ");
	                value = sc.nextLine();
	                break;

	            case 3:
	                column = "Student_Gender";
	                System.out.print("Enter Student Gender: ");
	                value = sc.nextLine();
	                break;

	            case 4:
	                column = "Student_Degree";
	                System.out.print("Enter Student Degree: ");
	                value = sc.nextLine();
	                break;

	            default:
	                System.out.println("Invalid Choice");
	                return;
	        }
        String select = "select * from student_details where "+column+" =?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?user=root&password=root");
		
		PreparedStatement ps = connections.prepareStatement(select);
		ps.setString(1, value);
		
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
