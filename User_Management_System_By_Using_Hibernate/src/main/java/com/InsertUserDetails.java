package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertUserDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//1.load the persistence.xml file
	EntityManagerFactory emf =	Persistence.createEntityManagerFactory("User_Management_System_By_Using_Hibernate");
	
	
	//2.Establish the connection 3.create the platform
	EntityManager em = emf.createEntityManager();
	
	//System.out.println("My Persistence file: "+em.getProperties() ); //give error for now if we want to get the data we need to use org.eclispe dependency in pom file instead of hibernate
	
	 EntityTransaction et = em.getTransaction();
	 
	 et.begin();
	 
	 UserInformation userInformation =  new UserInformation(); //not using the argumented constructor as we can't initilizing the id
	 System.out.println("Enter User Name");
	 userInformation.setName(sc.next());
	 
	 System.out.println("Enter User Email");
	 userInformation.setEmail(sc.next());
	 
	 System.out.println("Enter User Mobile Number");
	 userInformation.setMobilenumber(sc.nextLong());
	 
	 System.out.println("Enter User Gender");
	 userInformation.setGender(sc.next());
	 System.out.println(userInformation);
	 
	 
	 System.out.println("Before Persist: "+em.contains(userInformation));
	 em.persist(userInformation); //persist method is used to push the object to the orm and orm write the insert query to the database
	 
	 System.out.println("After Persist: "+em.contains(userInformation));  //return boolean value based on whether the orm contains object or not

	 System.out.println("Data inserted");
	 //5. perform the operations (insert,update,delete,select)
	 //if it is insert or update or delete ->//6. commit the transaction
	 
	 et.commit();
	 
	 //7.close the connection
	 em.close();

	}

}
