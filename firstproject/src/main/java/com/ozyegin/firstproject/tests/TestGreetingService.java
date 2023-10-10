package com.ozyegin.firstproject.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozyegin.firstproject.FirstprojectApplication;
import com.ozyegin.firstproject.beans.GreetingService;

public class TestGreetingService {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(FirstprojectApplication.class);
		GreetingService service= context.getBean(GreetingService.class);
		System.out.println(service.sayHello());
		//System.out.println(service.getRandomNumber());
		
		
//		GreetingService service2= context.getBean(GreetingService.class);
//		System.out.println(service2.getRandomNumber());
	}

}
