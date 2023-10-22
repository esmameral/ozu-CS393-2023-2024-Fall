package com.ozyegin.firstproject.dao;

import org.springframework.stereotype.Repository;

import com.ozyegin.firstproject.model.Course;
@Repository
public interface CourseDAO {
	public Course findByCode(String code);

}
