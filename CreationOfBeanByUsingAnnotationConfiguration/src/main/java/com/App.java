package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	//1. By traditional way using new keyword object is created
    	//2. Now by using IOC
    	
    	
    	//ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeDetails.class,Address.class); //AnnotationConfigApplicationContext is used to define for which class we are going to create the bean, and then applicationcontext create the bean of the that component class
    	ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeDetails.class); //first go to EmployeeDetails class then scan for other component class
    	String [] beanDefinitionNames = context.getBeanDefinitionNames();
    	for(String string: beanDefinitionNames) {
    		System.out.println(string);
    	}
    	
    	EmployeeDetails emp = context.getBean(EmployeeDetails.class);
    	
    	emp.displayEmployeeDetails();
    	
    	
    }
}
