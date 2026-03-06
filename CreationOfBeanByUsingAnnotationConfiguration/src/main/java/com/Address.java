package com;
//Create a Address class and configure the bean of Address BY using annotation

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	public Address() {
		System.out.println("Address has been generated");
	}

}
