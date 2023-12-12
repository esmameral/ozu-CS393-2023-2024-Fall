package com.demo.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.myschool.dto.StudentNameOnly;
import com.demo.myschool.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public StudentNameOnly findStudentById(int id);
	
	public List<Student> findByCoursesCode(String code);

}
