package com.demo.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myschool.dto.StudentNameOnly;
import com.demo.myschool.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public StudentNameOnly findStudentById(int id);

}
