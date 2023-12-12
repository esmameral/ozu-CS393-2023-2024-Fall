package com.demo.myschool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.myschool.service.CourseService;
@SpringBootTest
public class ServiceTests {
	
	@Autowired
	public CourseService service;

	@Test
	void testEnrollStudent() {
		service.enrollStudent("CS393", 4953);
	}

}