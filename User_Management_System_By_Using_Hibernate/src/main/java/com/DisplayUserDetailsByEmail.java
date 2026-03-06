package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DisplayUserDetailsByEmail {
	
	public static void main(String[] args) {
		
    Scanner sc = new Scanner(System.in);
		
		String select = " from UserInformation user where user.email=?1";
		
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("User_Management_System_By_Using_Hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Query query = em.createQuery(select);
		
		System.out.println("Enter the user email");
		query.setParameter(1, sc.next());
		
		try {
			
		UserInformation user = (UserInformation)query.getSingleResult();
		System.out.println(user);
		}catch(Exception e ) {
			System.out.println("No data found");
		}
		
		em.close();
	}

}
