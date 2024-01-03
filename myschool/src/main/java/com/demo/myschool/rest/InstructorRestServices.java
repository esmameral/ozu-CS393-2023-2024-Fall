package com.demo.myschool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myschool.dto.InstructorDTO;
import com.demo.myschool.service.InstructorService;

@RestController
@RequestMapping(value = "/instructors")
@CrossOrigin
public class InstructorRestServices {
	
	
	@Autowired
	InstructorService  service;
	
	@GetMapping
	public List<InstructorDTO> list(){
		
		return service.getAll();
		
	}
	
	@PostMapping
	public InstructorDTO save(@RequestBody InstructorDTO dto){
		
		return service.save(dto);
		
	}

}
