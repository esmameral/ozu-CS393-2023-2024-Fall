package com.ozyegin.firstproject;

import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@GetMapping("/sayHello")
	public String hello() {
		
		
		LocalTime currentTime = new LocalTime();
		String message = "The current local time is: " + currentTime;
		String helloMessage="Hello Spring Framework";

		

		return message+ " "+helloMessage;
		
	}

}
