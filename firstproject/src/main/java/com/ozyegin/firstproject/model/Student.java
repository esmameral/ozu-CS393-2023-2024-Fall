package com.ozyegin.firstproject.model;

import java.util.ArrayList;
import java.util.List;

public class Student  {
	private int id;
	private String name;

	
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
	private String department;
	
	private List<Course> courses = new ArrayList<>();

	
	public Student() {
		super();

	}

	public Student(String name, String department) {
		super();
		setName(name);
		this.department = department;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName() + ", department=" + department + "]";
	}

}
