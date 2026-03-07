package com;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CustomerDao;
import dao.CustomerDapImpl;

public class CustomerDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
		   	
		 //  CustomerDao dao = new CustomerDapImpl();
	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(CustomerDapImpl.class);

	        CustomerDao dao= context.getBean(CustomerDapImpl.class);

	        while(true){

	            System.out.println("\n1 Add Customer");
	            System.out.println("2 View All Customers");
	            System.out.println("3 Update Email By Mobile");
	            System.out.println("4 Delete Customer By Password");
	            System.out.println("5 Exit");

	            System.out.println("Enter Choice");

	            int choice = sc.nextInt();
	            
	            switch(choice) {

	            	case  1:
                    try {
                        dao.addCustomer();
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        dao.viewAllCustomers();
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        dao.updateEmailByMobile();
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        dao.deleteCustomerByPassword();
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
	        }

	}

}
