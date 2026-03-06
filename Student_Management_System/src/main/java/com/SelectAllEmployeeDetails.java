package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllEmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String select = "select * from iem.employee_details";
		//        **** OR *****
		String select = "select * from employee_details";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/iem?user=root&password=root");
		
		PreparedStatement ps = connections.prepareStatement(select);
		
		ResultSet resultSet=ps.executeQuery();
	//s	System.out.println(resultSet);
		if(resultSet.isBeforeFirst()) {
		
		while(resultSet.next()) {
			System.out.println("Data Existed");
			System.out.println("ID: "+resultSet.getInt("emp_id"));
			System.out.println("NAME: "+resultSet.getString("emp_name"));
			System.out.println("MOBILE NUMBER: "+resultSet.getLong("emp_mobile_number"));
			System.out.println("DEPT NO: "+resultSet.getInt("emp_deptno"));
			System.out.println("SALARY: "+resultSet.getDouble("emp_salary"));
		}
		}else {
			System.out.println("No	");
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
