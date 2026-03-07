package dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import model.CustomerInformation;
import service.Validation;

@Component("customer")
public class CustomerDapImpl implements CustomerDao{
	 Scanner sc = new Scanner(System.in);

	    EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("Customer_Management_System_By_Using_Hibernate");

	    @Override
	    public void addCustomer() {

	        System.out.println("Enter Name");
	        String name = sc.next();

	        System.out.println("Enter Email");
	        String email = sc.next();

	        Validation.emailValidation(email);
	        

	        System.out.println("Enter Mobile");
	        String mobile = sc.next();

	        Validation.mobileValidation(mobile);


	        System.out.println("Enter Password");
	        String pass = sc.next();

	        Validation.passwordValidation(pass);

	        CustomerInformation c = new CustomerInformation();

	        c.setName(name);
	        c.setEmail(email);
	        c.setMobilenumber(mobile);
	        c.setPassword(pass);

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        et.begin();
	        em.persist(c);
	        et.commit();

	        System.out.println("Customer Added Successfully");

	        em.close();
	    }

	    @Override
	    public void viewAllCustomers() {

	        EntityManager em = emf.createEntityManager();

	        Query query = em.createQuery("from CustomerInformation");

	        List<CustomerInformation> list = query.getResultList();
	        
	        if(list.isEmpty()) System.out.println("No customer found");
	        list.forEach(System.out::println);

	        em.close();
	    }

	    @Override
	    public void updateEmailByMobile() {

	        Scanner sc = new Scanner(System.in);

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        System.out.println("Enter Mobile Number");
	        String mobile = sc.next();
	        Validation.mobileValidation(mobile);

	        
	        System.out.println("Enter New Email");
	        String email = sc.next();

	        Validation.emailValidation(email);

	        String update = "update CustomerInformation c set c.email=?1 where c.mobilenumber=?2";

	        et.begin();

	        Query query = em.createQuery(update);

	        query.setParameter(1, email);
	        query.setParameter(2, mobile);

	        int res = query.executeUpdate();

	        if(res!=0)
	            System.out.println("Email Updated");
	        else
	            System.out.println("Customer Not Found");

	        et.commit();

	        em.close();
	    }

	    @Override
	    public void deleteCustomerByPassword() {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        System.out.println("Enter Password");
	        String pass = sc.next();
	        Validation.passwordValidation(pass);


	        String delete = "delete from CustomerInformation c where c.password=?1";

	        et.begin();

	        Query query = em.createQuery(delete);

	        query.setParameter(1, pass);

	        int res = query.executeUpdate();

	        if(res!=0)
	            System.out.println("Customer Deleted");
	        else
	            System.out.println("Invalid Password,Customer not found with this password");

	        et.commit();

	        em.close();
}
}
