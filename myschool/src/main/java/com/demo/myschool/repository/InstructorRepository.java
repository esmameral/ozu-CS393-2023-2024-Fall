package com.demo.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.myschool.model.Course;
import com.demo.myschool.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	
	public List<Instructor> findByNameOrderByRoomNumberDesc(String name);
	
	@Query("Select a from Instructor a where a.roomNumber=?1")
	public List<Instructor> findInst(String room);
	
	//@Query("Select c from Course c inner join c.instructor i where i.id=?1")
	@Query("Select c from Course c where c.instructor.id=?1")
	public List<Course> findAllCoursesWithInsId(int id);

	@Modifying
	@Query("Update Course c set c.instructor.id=?1 where c.id=?2")
	public void updateIns(int insId, int cId);

}
