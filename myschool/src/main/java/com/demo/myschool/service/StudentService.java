package com.demo.myschool.service;

import java.util.List;

import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.dto.StudentNameOnly;

public interface StudentService {
	public List<StudentDTO> getAll();
	public StudentDTO save(StudentDTO student);
	//public StudentDTO findStudent(int id);
	public StudentNameOnly getStudentById(int id);
	
	public List<StudentDTO> getAllStudentsForCourse(String course);
	

}
