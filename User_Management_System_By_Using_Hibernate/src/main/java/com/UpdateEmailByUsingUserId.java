package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmailByUsingUserId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("User_Management_System_By_Using_Hibernate");
		
		
		//2.Establish the connection 3.create the platform
		EntityManager em = emf.createEntityManager();  // have object 
				
		 EntityTransaction et = em.getTransaction();
		 
		 et.begin();
		 
		 System.out.println("Enter user id");
		 
		UserInformation user= em.find(UserInformation.class,sc.nextInt());
		
		if(user!=null) {
			System.out.println("Enter the new email id");
			user.setEmail(sc.next());
			
			em.merge(user);
			
			System.out.println("Email updted successfully");
		}
		else {
			System.out.println("No data found");
			
		}
		
		et.commit();
		 
		em.close();

	}

}
