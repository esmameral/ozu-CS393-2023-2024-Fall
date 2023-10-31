package com.ozyegin.jdbc.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.jdbc.dao.CourseDAO;
import com.ozyegin.jdbc.model.Course;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	CourseDAO dao;

	@Test
	void testCreateCustomer() {
		Course c=new Course((int)(Math.random()*100),"CS111","CS111 Name",4);
		int count=dao.save(c);
		assertTrue(count==1);
		
	}
	
	@Test
	void testQuery() {
		
		List<Course> courses=dao.findByCode("CS393");
		assertTrue(courses.size()==1);
		
	}

}
