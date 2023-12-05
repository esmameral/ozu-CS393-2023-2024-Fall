package com.demo.myschool.dto;
/**
 * Used for mapstruct mapping
 */
public class InstructorDTO {
	private int id;
	private String name;
	private String office;
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
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
}
