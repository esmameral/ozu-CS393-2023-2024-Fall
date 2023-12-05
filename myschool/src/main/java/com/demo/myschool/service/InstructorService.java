package com.demo.myschool.service;

import java.util.List;

import com.demo.myschool.dto.InstructorDTO;

public interface InstructorService {

	public List<InstructorDTO> getAll();

	public InstructorDTO save(InstructorDTO dto);
	
}
