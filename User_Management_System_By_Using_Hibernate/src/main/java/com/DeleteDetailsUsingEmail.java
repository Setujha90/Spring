package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDetailsUsingEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String delete = "delete from UserInformation user  where user.email=?1";
		
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("User_Management_System_By_Using_Hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		   Query query= em.createQuery(delete);
		   
		 //  System.out.println(query); // convert the jpql into sql,to check it we need to change in pom.xml use org.eclipse instead of hibernate 
         //still query is incomplete we need to complete the placeholder
		   
		   
		   System.out.println("Enter user email");
		   String email = sc.next();
		   query.setParameter(1, email);
		   
		 int res=  query.executeUpdate();
		 
		 if(res!=0) {
			 System.out.println("Data deleted");
		 }
		 else {
			 System.out.println("No data deleted");
		 }
		   
		   et.commit();
		   em.close();
	

	}

}
