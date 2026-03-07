package model;
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
	@Column(name="Customer_Email",nullable=false,unique=true)
	private String email;
	@Column(name="Mobile_Number",nullable=false,unique=true,length=10)
	private String mobilenumber;
	@Column(name="Password",nullable=false,unique=true,length=4)
	private String password;
	
	public CustomerInformation() {
		
	}
	
	public CustomerInformation(int id, String name,String email, String mobilenumber, String password) {
		super();
		this.id = id;
		this.name=name;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password =password ;
	}
	public int getId() {
		return id;
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerInformation [id=" + id + ",name="+ name + ", email=" + email + ", mobilenumber=" + mobilenumber + ", password="
				+ password + "]";
	}
	
	
	

}
