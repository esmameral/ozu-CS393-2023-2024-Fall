package com.ozyegin.cs393.hw1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ozyegin.cs393.hw1.beans.ProductBean;
import com.ozyegin.cs393.hw1.model.Product;

@Component
public class ProductListInitializr implements ApplicationRunner {
	@Autowired
	ProductBean productBean;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Product p1 = new Product(1, "WD 2TB Elements Portable External Hard Drive - USB 3.0 ", 64.0);

		Product p2 = new Product(2, "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s", 109);

		Product p3 = new Product(3,
				"Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED ",
				999.99);

		Product p4 = new Product(4, "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin", 599.0);
		productBean.getProductList().add(p1);
		productBean.getProductList().add(p2);
		productBean.getProductList().add(p3);
		productBean.getProductList().add(p4);
	}

}
