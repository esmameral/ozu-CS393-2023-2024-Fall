package com.demo.myschool.dto;
/**
 * Manuel mapping DTO example
 */
public class StudentDTO {
	private String program;
	private int id;
	private String name;
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentDTO(int id, String name, String program) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
	}
	
	
}
