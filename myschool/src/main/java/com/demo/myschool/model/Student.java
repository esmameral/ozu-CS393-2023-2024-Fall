package com.demo.myschool.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
//@DiscriminatorValue(value="STUDENT")

public class Student extends Person {
	
	private String program;
	
	private String address;
	@OneToOne
	private Transcript transcript;

	@ManyToMany(mappedBy = "students")
	private List<Course> courses = new ArrayList<>();

	public Student() {
		super();
	}
	
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName() + ", program=" + program + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
