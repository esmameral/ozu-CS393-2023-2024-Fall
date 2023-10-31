package com.ozyegin.jdbc.dao;

import java.util.List;

import com.ozyegin.jdbc.model.Course;
public interface CourseDAO {
	public List<Course> findByCode(String code);
	public int save(Course course);

}
