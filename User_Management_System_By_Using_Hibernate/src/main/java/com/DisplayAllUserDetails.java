package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

public class DisplayAllUserDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
		
		String select = " from UserInformation";
		
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("User_Management_System_By_Using_Hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Query query = em.createQuery(select);
		
		List<UserInformation> list = query.getResultList();  //get the list of object 
		
		for(UserInformation u:list) {
			System.out.println(u);
		}
		
		em.close();
		
		
		
	}

}
