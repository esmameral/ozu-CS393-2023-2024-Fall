package com.demo.myschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myschool.dto.CourseDTO;
import com.demo.myschool.dto.mapper.CourseMapper;
import com.demo.myschool.model.Course;
import com.demo.myschool.model.Instructor;
import com.demo.myschool.model.Student;
import com.demo.myschool.repository.CourseRepository;
import com.demo.myschool.repository.InstructorRepository;
import com.demo.myschool.repository.StudentRepository;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;

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

	@Override
	@Transactional
	public int createCourse(CourseDTO dto) {
		Course c=courseMapper.toCourse(dto);
		Instructor instructor=instructorRepository.findById(dto.getInstructorId()).get();
		c.setInstructor(instructor);
		instructor.getCourses().add(c);
		courseRepository.save(c);
		return c.getId();
		
	}

	@Override
	public List<CourseDTO> getAll() {
		return courseMapper.map(courseRepository.findAll()) ;
	}

}
