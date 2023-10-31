package com.ozyegin.cs393.hw1.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ozyegin.cs393.hw1.model.Product;

@Component
public class ProductBean {
	private List<Product> productList=new ArrayList<Product>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	

}
