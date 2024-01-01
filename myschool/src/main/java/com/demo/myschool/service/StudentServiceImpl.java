package com.demo.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.dto.StudentNameOnly;
import com.demo.myschool.dto.mapper.StudentMapper;
import com.demo.myschool.model.Student;
import com.demo.myschool.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;
	
	@Autowired
	StudentMapper studentMapper;

	@Override
	public List<StudentDTO> getAll() {
		
		return studentMapper.studentListToStudentDTOList(repository.findAll());
	}

	@Override
	public StudentDTO save(StudentDTO dto) {
		Student s=studentMapper.studentDTOToStudent(dto);
		
		
		Student newStudent=repository.save(s);
		
		return studentMapper.studentToStudentDTO(newStudent);
	}

//	@Override
//	public StudentDTO findStudent(int id) {
//		Optional<Student> opt=repository.findById(id);
//		if (opt.isPresent()) {
//			Student s=opt.get();
//			return studentMapper.studentToStudentDTO(s);
//		}
//		else 
//			return null;
//	}
	
	
	@Override
	   public StudentNameOnly getStudentById(int id) {
	       return repository.findStudentById( id);
	   }

	@Override
	public List<StudentDTO> getAllStudentsForCourse(String course) {
		List<Student> studentList= repository.findByCoursesCode(course);
		
		return studentMapper.studentListToStudentDTOList(studentList);
	}


}
