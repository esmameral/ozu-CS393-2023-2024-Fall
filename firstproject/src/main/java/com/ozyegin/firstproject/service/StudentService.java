package com.ozyegin.firstproject.service;

import com.ozyegin.firstproject.dao.CourseDAO;
import com.ozyegin.firstproject.dao.StudentDAO;
import com.ozyegin.firstproject.model.Student;

public interface StudentService {

	public Student findById(int id);

	public Student enrollCourse(String courseCode, int studentId);

	public int calculateTotalCreditForStudent(int studentId);

	public StudentDAO getStudentDAO();

	public void setStudentDAO(StudentDAO studentDAO);

	public CourseDAO getCourseDAO();

	public void setCourseDAO(CourseDAO courseDAO);

}