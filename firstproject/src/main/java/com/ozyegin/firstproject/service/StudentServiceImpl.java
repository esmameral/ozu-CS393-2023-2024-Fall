package com.ozyegin.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozyegin.firstproject.dao.CourseDAO;
import com.ozyegin.firstproject.dao.StudentDAO;
import com.ozyegin.firstproject.model.Course;
import com.ozyegin.firstproject.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO studentDAO;

	@Autowired
	CourseDAO courseDAO;

	@Override
	public Student findById(int id) {
		return  studentDAO.findById(id);
	}
	
	@Override
	public Student enrollCourse(String courseCode, int studentId) {
		Student aStudent = studentDAO.findById(studentId);
		Course aCourse = courseDAO.findByCode(courseCode);
		aStudent.getCourses().add(aCourse);
		studentDAO.save(aStudent);
		return aStudent;
	}
	
	@Override
	public int calculateTotalCreditForStudent(int studentId) {
		int totalCredit=0;
		Student aStudent = studentDAO.findById(studentId);
		for (Course course : aStudent.getCourses()) {
			totalCredit+=course.getCredit();
		}
		return totalCredit;
	}
	
	@Override
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	@Override
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	@Override
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	
	

}
