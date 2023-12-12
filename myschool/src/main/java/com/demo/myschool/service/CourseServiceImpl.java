package com.demo.myschool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myschool.model.Course;
import com.demo.myschool.model.Student;
import com.demo.myschool.repository.CourseRepository;
import com.demo.myschool.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Override
	@Transactional
	public boolean enrollStudent(String courseCode, int studentId) {
		Course course = courseRepository.findByCode(courseCode);
		Optional<Student> opt = studentRepository.findById(studentId);
		if (opt.isPresent()) {
			Student student = opt.get();

			course.getStudents().add(student);
			courseRepository.save(course);
			student.getCourses().add(course);
			studentRepository.save(student);
		
			return true;
		} else
			return false;
	}

}
