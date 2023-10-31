package com.ozyegin.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ozyegin.jdbc.model.Course;

@Component
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Course> findByCode(String code) {
		String sql="SELECT ID, COURSE_NAME, CODE, CREDIT FROM T_COURSE  WHERE CODE=?";
		return jdbcTemplate.query(sql, new CourseRowMapper(), code);
	}
	
	class CourseRowMapper implements RowMapper<Course> {

		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course c=new Course();
			c.setId(rs.getInt(1));
			c.setCredit(rs.getInt(4));
			c.setName(rs.getString(2));
			c.setCode(rs.getString(3));
			return c;
		}
		
	}

	@Override
	public int save(Course course) {
		String sql="INSERT INTO t_course (id, course_name,code,credit) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {course.getId(),course.getName(),course.getCode(),course.getCredit()});
		
	}

}
