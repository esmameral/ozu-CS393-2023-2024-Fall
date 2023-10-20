package com.ozyegin.cs393.hw1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.cs393.hw1.beans.ProductBean;

@RestController
public class RestfulServices {
	ProductBean productBean;
	
	String welcomeMessage;
	
	String headerMessage;
	
	@GetMapping(value="/products")
	public List<String> listProducts() {
		List<String> messages=new ArrayList<String>();
		messages.add(welcomeMessage);
		messages.add(headerMessage);
		//add products to messages list
		
		return messages;
	}

	
}
