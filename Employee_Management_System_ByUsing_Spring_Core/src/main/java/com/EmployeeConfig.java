package com;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration //Create the Bean of EMployeeConfig inside IOC like @Component and also telling that it have method which will create the bean of inbuilt class inside the IOC
public class EmployeeConfig {
	
//	@Bean  // Convert the object of scanner into the bean and store inside the IOC
//	
//	public Scanner scannerBean() {
//		System.out.println("Scanning........");
//		return new Scanner(System.in);
//	}
	
	@Bean  // Convert the object of scanner into the bean and store inside the IOC
//	@Primary //making them primary to avoid ambiguity
	public Scanner scannerBean2() {
		return new Scanner(System.in);
	}
	

}
