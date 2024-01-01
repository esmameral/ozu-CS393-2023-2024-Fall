package com.demo.myschool.dto;

public class CreateCourseDTO {
	private int id;
	private String name;
	private String code;
	private int credit;
	private int instructorId;
	
	public CreateCourseDTO(int id, String name, String code, int credit, int instructorId) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.credit = credit;
		this.instructorId = instructorId;
	}
	public CreateCourseDTO() {
		super();
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	
}
