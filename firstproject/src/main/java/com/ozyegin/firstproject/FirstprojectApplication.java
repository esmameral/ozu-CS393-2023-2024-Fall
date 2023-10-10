package com.ozyegin.firstproject;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.firstproject.beans.GreetingService;

@SpringBootApplication
@RestController
public class FirstprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	

	@Autowired
	private GreetingService greetingService;
		
	@Bean("df")
	public SimpleDateFormat getDateFormat() {
		SimpleDateFormat dfo=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dfo;
	}

	@GetMapping("/sayHello")
	public String hello() {
//		LocalTime currentTime = new LocalTime();
//		String message = "The current local time is: " + currentTime;
//		return message  + " " + greetingService.sayHello();
		return greetingService.sayHello();
	}

}
