package com.demo.myschool.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.myschool.dto.StudentDTO;
import com.demo.myschool.model.Student;
/**
 * Manuel mapping example
 */
@Component
public class StudentMapper {

	public StudentDTO studentToStudentDTO(Student s) {
		return new StudentDTO(s.getId(), s.getName(), s.getProgram());
	}

	public Student studentDTOToStudent(StudentDTO d) {
		Student s = new Student();
		s.setId(d.getId());
		s.setName(d.getName());
		s.setProgram(d.getProgram());
		return s;
	}

	public List<StudentDTO> studentListToStudentDTOList(List<Student> list) {
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();

		for (Student student : list) {
			StudentDTO dto = studentToStudentDTO(student);
			dtoList.add(dto);
		}
		return dtoList;
	}

}
