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
import com.demo.myschool.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
	@Operation(summary = "Find a student by ID", 
	description = "Returns a single student", tags = { "id" })
@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = StudentNameOnly.class))),
	@ApiResponse(responseCode = "404", description = "Contact not found") })
	public StudentNameOnly getSelectedStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	@PostMapping
	@Operation(summary = "Creates a new Student", description = "Saves a new student info into database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "created"),
			@ApiResponse(responseCode = "200", description = "successful operation")		
	})
	public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO student) {
		StudentDTO dto = studentService.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping(value = "/{courseCode}")
	public List<StudentDTO> getAllStudentsForCourse(@PathVariable("courseCode") String courseCode) {
		return studentService.getAllStudentsForCourse(courseCode);
	}

}
