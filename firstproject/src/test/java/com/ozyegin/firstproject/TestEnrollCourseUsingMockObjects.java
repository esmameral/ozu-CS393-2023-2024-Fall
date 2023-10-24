package com.ozyegin.firstproject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ozyegin.firstproject.dao.CourseDAO;
import com.ozyegin.firstproject.dao.StudentDAO;
import com.ozyegin.firstproject.model.Course;
import com.ozyegin.firstproject.model.Student;
import com.ozyegin.firstproject.service.StudentService;

@SpringBootTest

class TestEnrollCourseUsingMockObjects {
	@MockBean
	CourseDAO courseDAO;

	@MockBean
	StudentDAO studentDAO;
	
	@Autowired
	StudentService service;

	@Test
	void test() {
		int studentId=1;
		String courseCode="CS391";
		Course newCourse=new Course(courseCode,"Web Programming",4);
		//Set expectations
		Student student=new Student(1, "Feyza");
		Course course1=new Course("CS102","OO Programming",6);
		Course course2=new Course("CS393","Backend Applications",4);
		student.getCourses().add(course1);
		student.getCourses().add(course2);
		
		Mockito.when(studentDAO.findById(studentId)).thenReturn(student);
		Mockito.when(courseDAO.findByCode(courseCode)).thenReturn(newCourse);
		
		
		//Run
		Student aStudent=studentDAO.findById(studentId);
		int count=aStudent.getCourses().size();
		int totalCredit=service.calculateTotalCreditForStudent(aStudent.getId());
		assertTrue(count==2);
		assertTrue(totalCredit==10);
		
		service.enrollCourse(courseCode, studentId);
		totalCredit=service.calculateTotalCreditForStudent(studentId);
		assertTrue(totalCredit==14);
		int newCount=aStudent.getCourses().size();
		assertTrue(newCount==count+1);
				
		//Verify
		Mockito.verify(studentDAO, times(4)).findById(studentId);
		Mockito.verify(courseDAO, times(1)).findByCode(courseCode);
		Mockito.verify(studentDAO,times(1)).save(aStudent);	
		
	}

}
