package com.ozyegin.firstproject.dao;

import org.springframework.stereotype.Repository;

import com.ozyegin.firstproject.model.Student;
@Repository
public interface StudentDAO {
	public Student findById(int id);

	public void save(Student aStudent);

}
