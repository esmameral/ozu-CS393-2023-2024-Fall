package com.demo.myschool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myschool.model.Student;
import com.demo.myschool.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentRestServices {
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudents() {
		
		return studentService.getAll();
	}
	
	
	
	
	

}
