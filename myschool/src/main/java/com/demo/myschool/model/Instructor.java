package com.demo.myschool.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
//@DiscriminatorValue(value="INSTRUCTOR")
public class Instructor extends Person {
	private String roomNumber;

	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.ALL})
	private List<Course> courses = new ArrayList<>();

	public Instructor() {
		super();
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + getId() + ", name=" + getName() + ", roomNumber=" + getRoomNumber() + "]";
	}

	

	

}
