package dao;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import model.Product;

@Component("product")
public class ProductDaoImpl implements ProductDao{
	 Scanner sc = new Scanner(System.in);

	    EntityManagerFactory emf =
	    Persistence.createEntityManagerFactory("Product_Management_System");

	   

	    @Override
	    public void addProduct() {
	    	EntityManager em = emf.createEntityManager();

		    EntityTransaction et = em.getTransaction();
	        et.begin();

	        Product p = new Product();

	        System.out.println("Enter Product Name");
	        p.setName(sc.next());

	        System.out.println("Enter Product Category");
	        p.setCategory(sc.next());

	        System.out.println("Enter Product Price");
	        p.setPrice(sc.nextDouble());

	        em.persist(p);

	        et.commit();

	        System.out.println("Product Added Successfully");
	    }

	    @Override
	    public void viewAllProducts() {
	    	EntityManager em = emf.createEntityManager();

	        String select = "from Product";

	        Query query = em.createQuery(select);

	        List<Product> list = query.getResultList();

	        for(Product p : list) {
	            System.out.println(p);
	        }
	    }

	    @Override
	    public void updatePrice() {
	    	EntityManager em = emf.createEntityManager();

		    EntityTransaction et = em.getTransaction();
	        String update = "update Product p set p.price=?1 where p.id=?2 and p.name=?3";

	        et.begin();

	        Query query = em.createQuery(update);

	        System.out.println("Enter New Price");
	        query.setParameter(1, sc.nextDouble());

	        System.out.println("Enter Product Id");
	        query.setParameter(2, sc.nextInt());

	        System.out.println("Enter Product Name");
	        query.setParameter(3, sc.next());

	        int res = query.executeUpdate();

	        if(res != 0)
	            System.out.println("Price Updated");
	        else
	            System.out.println("No Product Found");

	        et.commit();
	    }

	    @Override
	    public void deleteProduct() {
	    	EntityManager em = emf.createEntityManager();

		    EntityTransaction et = em.getTransaction();
	        String delete = "delete from Product p where p.id=?1";

	        et.begin();

	        Query query = em.createQuery(delete);

	        System.out.println("Enter Product Id");
	        query.setParameter(1, sc.nextInt());

	        int res = query.executeUpdate();

	        if(res != 0)
	            System.out.println("Product Deleted");
	        else
	            System.out.println("No Product Found");

	        et.commit();
	    }

	    @Override
	    public void getProductByCategory() {
	    	EntityManager em = emf.createEntityManager();

	        String select = "from Product p where p.category=?1";

	        Query query = em.createQuery(select);

	        System.out.println("Enter Category");
	        query.setParameter(1, sc.next());

	        List<Product> list = query.getResultList();

	        if(list.isEmpty())
	            System.out.println("No Product Found");
	        else
	            list.forEach(System.out::println);
	    }
}
