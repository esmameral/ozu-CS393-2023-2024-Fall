package com.demo.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.myschool.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	public List<Instructor> findByNameOrderByRoomNumberDesc(String name);
	
	@Query("Select a from Instructor a where a.roomNumber=?1")
	public List<Instructor> findInst(String room);

}
