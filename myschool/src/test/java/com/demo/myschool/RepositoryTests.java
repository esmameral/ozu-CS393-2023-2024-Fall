package com.demo.myschool;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.myschool.model.Course;
import com.demo.myschool.model.Instructor;
import com.demo.myschool.model.Student;
import com.demo.myschool.repository.InstructorRepository;
import com.demo.myschool.repository.StudentRepository;
import com.demo.myschool.service.CourseService;
import com.demo.myschool.service.StudentService;

@SpringBootTest
class RepositoryTests {
	@Autowired
	InstructorRepository instructorRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseService service;
	

	@Test
	void testEnrollStudent() {
		service.enrollStudent("CS201", 5002);
	}
	
	
	
	@Test
	void testGetStudents() {
		List<Student> list= studentRepository.findByCoursesCode("CS393");
		assertTrue(list.size()==2);
	}
	
	@Test
	void testSaveInstructorAndCourses() {
		Instructor instructor = new Instructor();
		instructor.setName("Feyza");
		instructor.setRoomNumber("222");

		Course course1 = new Course("CS393", "Backend app", 4);
		course1.setInstructor(instructor);

		Course course2 = new Course("CS201", "Algorithms", 6);
		course2.setInstructor(instructor);

		instructor.getCourses().add(course1);
		instructor.getCourses().add(course2);

		instructorRepository.save(instructor);
		assertTrue(instructor.getId() > 0);
	}

	@Test
	void testSaveInstructor() {
		Instructor instructor = new Instructor();
		instructor.setName("Kerem");
		instructor.setRoomNumber("301");
		instructorRepository.save(instructor);
		assertTrue(instructor.getId() > 0);
	}

	@Test
	void testReadInstructorById() {

		Instructor ins = instructorRepository.findById(52).get();
		assertTrue(ins.getId() == 52);
		assertTrue(ins.getName().equals("Kerem"));
	}

	@Test
	void testReadInstructorByName() {
		List<Instructor> list = instructorRepository.findByNameOrderByRoomNumberDesc("Kerem");
		assertTrue(list != null);
		assertTrue(list.size() > 0);
		for (Instructor instructor : list) {
			System.out.println(instructor);

		}
	}

	@Test
	void testReadInstructorByQuery() {
		List<Instructor> list = instructorRepository.findInst("112");
		assertTrue(list != null);
		assertTrue(list.size() > 0);
		for (Instructor instructor : list) {
			System.out.println(instructor);

		}

	}

	@Test
	
	void testOrphanRemoval() {
		Instructor instructor = new Instructor();
		instructor.setName("Kerem");
		instructor.setRoomNumber("123");

		Course course1 = new Course("CS202", "CS202 ", 6);
		course1.setInstructor(instructor);

		Course course2 = new Course("CS203", "CS203", 4);
		course2.setInstructor(instructor);

		instructor.getCourses().add(course1);
		instructor.getCourses().add(course2);

		instructorRepository.save(instructor);

		assertTrue(instructor.getId() > 0);
		for (Course c : instructor.getCourses()) {
			assertTrue(c.getId() > 0);
		}

		assertTrue(instructor.getCourses().size() == 2);
		course1.setInstructor(null);
		// If you add "orphanRemoval = true" in Instructor,
		// it will also delete removed Course from database 
		 int index = instructor.getCourses().indexOf(course2);
		instructor.getCourses().remove(index);
		
		instructorRepository.save(instructor);
		assertTrue(instructor.getCourses().size() == 1);

	}
	
	@Test
//	@Transactional
//	@Commit
	void testJPQL() {
		List<Course> courses= instructorRepository.findAllCoursesWithInsId(22);
		for (Course course : courses) {
			System.out.println(course);
		}
		
		instructorRepository.updateIns(22,33);

	}

}
