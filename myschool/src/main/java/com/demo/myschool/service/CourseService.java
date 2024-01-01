package com.demo.myschool.service;

import com.demo.myschool.dto.CreateCourseDTO;

public interface CourseService {
	public boolean enrollStudent(String courseCode, int studentId);
	public int createCourse(CreateCourseDTO dto);
}
