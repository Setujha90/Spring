package com;
import javax.persistence.*;

@Entity
@Table(name="Customer_Information")
public class CustomerInformation {
	
	@Id
	@Column(name="Customer_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Customer_Name",nullable=false,unique=true)
	private String name;
	@Column(name="Mobile_Number",nullable=false,unique=true,length=10)
	private long mobilenumber;
	@Column(name="Gender",nullable=false)
	private String gender;
	
	public CustomerInformation() {
		
	}
	
	public CustomerInformation(int id, String name, long mobilenumber, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerInformation [id=" + id + ", name=" + name + ", mobilenumber=" + mobilenumber + ", gender="
				+ gender + "]";
	}
	
	
	

}
