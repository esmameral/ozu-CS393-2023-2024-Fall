package com.demo.myschool.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.demo.myschool.dto.InstructorDTO;
import com.demo.myschool.model.Instructor;
/**
 * mapstruct mapping example
 */
@Mapper(componentModel = "spring")
public interface InstructorMapper {
	InstructorMapper INSTANCE = Mappers.getMapper( InstructorMapper.class);
	 
	    @Mapping(source = "roomNumber", target = "office")
	    InstructorDTO instructorToInstructorDTO(Instructor ins);
	    
	    
	    @InheritInverseConfiguration
	    @Mapping(target = "courses", ignore = true)
	    @Mapping(target = "workingArea", ignore = true)
	    Instructor instructorDTOToInstructor(InstructorDTO dto);
}
