package com.demo.myschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(version = "1.1", 
title = "School Management System API", 
description = "All Administration Operations",
contact = @Contact(email="esma.meral@ozu.edu.tr", name = "Esma Meral")))

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
