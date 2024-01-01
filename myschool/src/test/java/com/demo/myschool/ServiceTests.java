package com.demo.myschool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.model.Student;
import com.demo.myschool.service.CourseService;
import com.demo.myschool.service.StudentService;
@SpringBootTest
public class ServiceTests {
	
	@Autowired
	public CourseService courseService;
	@Autowired
	public StudentService studentService;

	@Test
	void testEnrollStudent() {
		StudentDTO s=new StudentDTO();
		s.setName("Ayse");
		s.setProgram("CS");
		StudentDTO dto=studentService.save(s);
		
		courseService.enrollStudent("CS393", dto.getId());
	}

}