package com.demo.myschool.service;

import java.util.List;

import com.demo.myschool.dto.CourseDTO;

public interface CourseService {
	public boolean enrollStudent(String courseCode, int studentId);
	public int createCourse(CourseDTO dto);
	public List<CourseDTO> getAll();
}
