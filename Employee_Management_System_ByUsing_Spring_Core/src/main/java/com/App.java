package com;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConnections.class);
    	
//    	DataBaseConnections connections = context.getBean(DataBaseConnections.class);
    	EmployeeDataBaseOperations operations = context.getBean(EmployeeDataBaseOperations.class);
    	
			    Scanner scanner = context.getBean(Scanner.class);

    			while (true) {

    				System.out.println("\nEmployee Database Menu");
    				System.out.println("1. Insert Employee");
    				System.out.println("2. Get All Employees");
    				System.out.println("3. Get Employee By ID");
    				System.out.println("4. Update Salary By Department");
    				System.out.println("5. Delete Employee By ID");
    				System.out.println("6. Exit");

    				System.out.println("Enter your choice:");
    				int choice = scanner.nextInt();

    				switch (choice) {

    				case 1:
    					operations.insertEmployeeDetails();
    					break;

    				case 2:
    					operations.getAllEmployeeDetails();
    					break;

    				case 3:
    					operations.getEmployeeById();
    					break;

    				case 4:
    					operations.updateSalaryByDeptno();
    					break;

    				case 5:
    					operations.deleteEmployeeById();
    					break;

    				case 6:
    					System.out.println("Exiting Application...");
    					System.exit(0);

    				default:
    					System.out.println("Invalid choice");
    				}
    			}
    		}
    }

