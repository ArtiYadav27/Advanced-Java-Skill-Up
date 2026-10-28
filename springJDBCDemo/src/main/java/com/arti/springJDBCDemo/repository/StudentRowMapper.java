package com.arti.springJDBCDemo.repository;

import com.arti.springJDBCDemo.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//although implementation is required to be given externally but no need to call it manually, it will call it internally while mapping
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student=new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
