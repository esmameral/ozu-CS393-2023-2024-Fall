package com.demo.myschool.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String code;
	private int credit;
	
	@ManyToMany
	@JoinTable(name = "REL_COURSE_STUDENT", 
	joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
	private List<Student> students=new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "INS_ID")
	private Instructor instructor;

	public Course() {
		super();
	}

	public Course(String code, String name, int credit) {
		this.code=code;
		this.name=name;
		this.credit=credit;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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
