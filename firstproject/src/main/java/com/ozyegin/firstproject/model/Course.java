package com.ozyegin.firstproject.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
   

	private int id;
    
    
	private String name;
    
	private String code;
	private int credit;
	
	
	private List<Student> students=new ArrayList<>();
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	

	public Course() {
		super();
	}

	public Course(String code, String name, int credit) {
		this.code=code;
		this.name=name;
		this.credit=credit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	 @Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", code=" + code + ", credit=" + credit + "]";
		}

}
