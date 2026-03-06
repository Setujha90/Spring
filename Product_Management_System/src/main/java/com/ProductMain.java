package com;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ProductDao;
import dao.ProductDaoImpl;
public class ProductMain {
	  public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        		// ProductDao dao = new ProductDaoImpl(); // runtime polymorphism (Traditional way)
	        
	        		ApplicationContext context =
	                new AnnotationConfigApplicationContext(ProductDaoImpl.class);

	                ProductDao dao = context.getBean(ProductDaoImpl.class);

	        while(true) {

	            System.out.println("\n1 Add Product");
	            System.out.println("2 View All Products");
	            System.out.println("3 Update Product Price");
	            System.out.println("4 Delete Product");
	            System.out.println("5 Get Product By Category");
	            System.out.println("6 Exit");

	            System.out.println("Enter Choice");

	            int choice = sc.nextInt();

	            switch(choice) {

	                case 1: dao.addProduct(); break;

	                case 2: dao.viewAllProducts(); break;

	                case 3: dao.updatePrice(); break;

	                case 4: dao.deleteProduct(); break;

	                case 5: dao.getProductByCategory(); break;

	                case 6: System.exit(0);

	                default: System.out.println("Invalid Choice");
	            }
	        }
	    }
}
