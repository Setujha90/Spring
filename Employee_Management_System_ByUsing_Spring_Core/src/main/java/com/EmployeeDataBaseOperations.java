package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataBaseOperations {
	
	@Autowired   //it will find the bean of dataBaseConnections in the IOC Container and assign the bean to below reference
	DataBaseConnections dataBaseConnections;
		
		@Autowired
	//	@Qualifier("scannerBean") //telling that we are going to use the bean of scannerBean (to avoid the ambiguity) (Use any one out of qualifier and primary)
		Scanner scanner ;
		public void insertEmployeeDetails() {
			
			Connection connection = dataBaseConnections.mysqlDBConnection();
			System.out.println("Connections establish");
			
			
			System.out.println("Enter Employee Name");
			String name = scanner.next();
			 
			System.out.println("Enter Employee Department Number");
			int deptno = scanner.nextInt();
			
			System.out.println("Enter Employee Salary");
			Double salary = scanner.nextDouble();
			
			String insert  =  "insert into employeedb.employee_details (emp_name,emp_deptno,emp_salary) values (?,?,?)";
			
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(insert);
				//Making the query as complete query
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, deptno);
				preparedStatement.setDouble(3, salary);
				
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	
		public void getAllEmployeeDetails() {

			Connection connection = dataBaseConnections.mysqlDBConnection();

			String query = "select * from employeedb.employee_details";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.isBeforeFirst()) {
				while (resultSet.next()) {

					int id = resultSet.getInt("emp_id");
					String name = resultSet.getString("emp_name");
					int deptno = resultSet.getInt("emp_deptno");
					double salary = resultSet.getDouble("emp_salary");

					System.out.println(id + " " + name + " " + deptno + " " + salary);
				}

			}
			else {
				System.out.println("No employee data is present");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		public void getEmployeeById() {

			Connection connection = dataBaseConnections.mysqlDBConnection();

			System.out.println("Enter Employee ID");
			int id = scanner.nextInt();

			String query = "select * from employeedb.employee_details where emp_id=?";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, id);

				ResultSet resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {

					String name = resultSet.getString("emp_name");
					int deptno = resultSet.getInt("emp_deptno");
					double salary = resultSet.getDouble("emp_salary");

					System.out.println(id + " " + name + " " + deptno + " " + salary);
				} else {
					System.out.println("Employee not found");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		public void updateSalaryByDeptno() {

			Connection connection = dataBaseConnections.mysqlDBConnection();

			System.out.println("Enter Department Number");
			int deptno = scanner.nextInt();

			System.out.println("Enter New Salary");
			double salary = scanner.nextDouble();

			String query = "update employeedb.employee_details set emp_salary=? where emp_deptno=?";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setDouble(1, salary);
				preparedStatement.setInt(2, deptno);

				int result = preparedStatement.executeUpdate();

				if (result != 0) {
					System.out.println("Salary updated successfully");
				} else {
					System.out.println("No employee found with this department");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		public void deleteEmployeeById() {

			Connection connection = dataBaseConnections.mysqlDBConnection();

			System.out.println("Enter Employee ID to delete");
			int id = scanner.nextInt();

			String query = "delete from employeedb.employee_details where emp_id=?";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, id);

				int result = preparedStatement.executeUpdate();

				if (result != 0) {
					System.out.println("Employee deleted successfully");
				} else {
					System.out.println("Employee not found");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

				

}
