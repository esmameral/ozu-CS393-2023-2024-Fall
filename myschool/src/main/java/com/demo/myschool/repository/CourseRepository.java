package com.demo.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myschool.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	public Course findByCode(String code);
}
