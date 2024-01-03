package com.demo.myschool.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.demo.myschool.dto.CourseDTO;
import com.demo.myschool.model.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

	@Mapping(target = "topics", ignore = true)
	@Mapping(target = "students", ignore = true)
	@Mapping(source = "instructorId", target="instructor.id")
	
	Course toCourse(CourseDTO dto);
	
	List<CourseDTO> map(List<Course> courses);

}
