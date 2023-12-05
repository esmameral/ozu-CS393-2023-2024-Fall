package com.demo.myschool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.dto.StudentNameOnly;
import com.demo.myschool.model.Student;
import com.demo.myschool.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentRestServices {
	@Autowired
	StudentService studentService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<StudentDTO> getAllStudents() {
		
		return studentService.getAll();
	}
	
//	@GetMapping(value = "/{id}")
//	public StudentDTO getSelectedStudent(@PathVariable("id") int id) {
//		return studentService.findStudent(id);
//	}
	
	@GetMapping(value = "/{id}")
	public StudentNameOnly getSelectedStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping
	public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
		 
	}
	
	
	
	
	

}
