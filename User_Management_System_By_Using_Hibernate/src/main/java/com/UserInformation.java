package com;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User_Information") // use to provide the different name to the database table name 
public class UserInformation {
	
	@Id
	@Column(name="User_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //use for auto increment of the id 
	private int id;
	@Column(name="User_Name",nullable = false) //making it not null
	private String name;
	@Column(name="User_Email",nullable = false, unique = true)
	private String email;
	@Column(name="Mobile_Number",nullable = false , unique=true,length =10)
	private long mobilenumber;
	@Column(name="Gender",nullable = false)
private String gender;
	
	public UserInformation() {
		
	}
	
	public UserInformation(int id, String name, String email, long mobilenumber, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "UserInformation [id=" + id + ", name=" + name + ", email=" + email + ", mobilenumber=" + mobilenumber
				+ ", gender=" + gender + "]";
	}
	
	
	
}
