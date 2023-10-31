package com.ozyegin.cs393.hw1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.cs393.hw1.beans.DailyDiscountSelector;
import com.ozyegin.cs393.hw1.beans.ProductBean;
import com.ozyegin.cs393.hw1.model.Product;

@RestController
public class RestfulServices {
	@Autowired
	private ProductBean productBean;
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${header.message}")
	private String headerMessage;
	
	@Autowired
	private DailyDiscountSelector discountSelector;
	
	@GetMapping(value="/products")
	public List<String> listProducts() {
		List<String> messages=new ArrayList<String>();
		messages.add(welcomeMessage);
		messages.add(headerMessage);
		for (Product product : productBean.getProductList()) {
			messages.add(product.toString());
		}
		messages.add("You are lucky. Today's discount rate is "+discountSelector.getDailyDiscountRate());
		return messages;
	}

	
}
