package com.ozyegin.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.firstproject.beans.GreetingService;

@RestController
public class RestfulServices {
	@Autowired
	private GreetingService greetingService;
		


	@GetMapping("/sayHello")
	public String hello() {
//		LocalTime currentTime = new LocalTime();
//		String message = "The current local time is: " + currentTime;
//		return message  + " " + greetingService.sayHello();
		return greetingService.sayHello();
	}
}
