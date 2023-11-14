package com.demo.myschool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		return id == other.id;
	}

}
