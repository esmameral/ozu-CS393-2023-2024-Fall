package com.demo.myschool.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.demo.myschool.dto.CreateCourseDTO;
import com.demo.myschool.model.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

//	 @Mapping(source = "roomNumber", target = "office")
//	 CreateCourseDTO instructorToInstructorDTO(Instructor ins);

	@Mapping(target = "topics", ignore = true)
	@Mapping(target = "students", ignore = true)
	@Mapping(source = "instructorId", target="instructor.id")
	
	Course toCourse(CreateCourseDTO dto);

//	    @InheritInverseConfiguration
//	    CustomerDto fromCustomer(Customer customer);
}
