package com.demo.myschool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myschool.dto.CourseDTO;
import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.service.CourseService;
import com.demo.myschool.service.StudentService;

@RestController
@RequestMapping(value = "/courses")
@CrossOrigin
public class CourseRestServices {
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;

	@GetMapping(value = "/{code}/students")
	public List<StudentDTO> getAllStudentsForCourse(@PathVariable("code") String code) {
		return studentService.getAllStudentsForCourse(code);
	}
	@GetMapping
	public List<CourseDTO> getAll() {
		return courseService.getAll();
	}
	
	@PostMapping
	public int createCourse(@RequestBody CourseDTO dto) {
		 return courseService.createCourse(dto);
	}
	
	//courses/CS393/students/S024344
	@PutMapping(value = "/{courseCode}/students/{studentId}")
	public boolean enrollStudent(@PathVariable String courseCode, 
			@PathVariable int studentId) {
		return courseService.enrollStudent(courseCode, studentId);
	}
	

}
