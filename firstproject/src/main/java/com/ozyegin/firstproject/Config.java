package com.ozyegin.firstproject;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean("df")
	public SimpleDateFormat getDateFormat() {
		SimpleDateFormat dfo = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dfo;
	}
}
