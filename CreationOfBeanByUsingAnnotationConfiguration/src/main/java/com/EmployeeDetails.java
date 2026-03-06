package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("emp")  //"emp" give alternate name to the camelcase reference of the created bean inside the IOC
@ComponentScan(basePackages="com")
public class EmployeeDetails {
	
	public EmployeeDetails(){
		System.out.println("Object created");
	}
	
	public void displayEmployeeDetails() {
		System.out.println("Employee Name: ABC ");
		System.out.println("Employee Salary: 650000");
	}

}
