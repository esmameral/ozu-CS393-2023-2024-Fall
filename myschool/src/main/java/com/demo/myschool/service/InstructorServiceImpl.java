package com.demo.myschool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.myschool.dto.InstructorDTO;
import com.demo.myschool.dto.mapper.InstructorMapper;
import com.demo.myschool.model.Instructor;
import com.demo.myschool.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorMapper  mapper;
	
	@Autowired
	InstructorRepository repository;
	
	@Override
	public List<InstructorDTO> getAll() {
		
		List<Instructor> list =repository.findAll();
		List<InstructorDTO> dtoList=new ArrayList<InstructorDTO>();
		for (Instructor instructor : list) {
			dtoList.add(mapper.instructorToInstructorDTO(instructor));
		}
		return dtoList;
	}

	@Override
	public InstructorDTO save(InstructorDTO dto) {
		Instructor ins=repository.save(mapper.instructorDTOToInstructor(dto));
		return mapper.instructorToInstructorDTO(ins);
	}
	
	
	
}
