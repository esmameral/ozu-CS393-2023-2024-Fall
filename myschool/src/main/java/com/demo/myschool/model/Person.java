package com.demo.myschool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="PERSON_TYPE", length=20)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	private String name;

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id, Instructor instructor) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name, Instructor instructor) {
		this.name = name;
	}

}