package com.ozyegin.firstproject;

import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ozyegin.firstproject.model.Course;
import com.ozyegin.firstproject.model.Student;

class TestStudent {
	
	
	@Test
	void testStudentObject()  {
		Student student=new Student(121,"Ece");
		assertTrue(student.getName()=="Ece","Check your getName method");
		assertTrue(student.getId()==121);
		
		
	}
	
	@Test
	void testAddCourse()  {
		Student student=new Student(121,"Ece");
		
		assertEquals(0, student.getCourses().size());
		
		Course course=new Course("CS393","Developing Backend Applications",4);
		student.getCourses().add(course);
		assertEquals(1, student.getCourses().size());
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	

}
