package model;

import javax.persistence.*;

@Entity
public class Product {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Product_Id")
	    private int id;
		@Column(name="Product_Name",nullable = false)
	    private String name;
		@Column(name="Product_Category",nullable = false)
	    private String category;
	    @Column(name="Product_Price",nullable = false)
	    private double price;

	    public Product() {}

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	    }
}
