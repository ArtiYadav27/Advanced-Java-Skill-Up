package com.arti.springJDBCDemo.repository;


import com.arti.springJDBCDemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> rowMapper=new BeanPropertyRowMapper<>(Student.class);
    private StudentRowMapper studentRowMapper=new StudentRowMapper();
    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public String createStudent(Student student){
        String sql= """
        insert into student(name,email,age) values(?,?,?)
        """;

        int rowAffected=jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge());
        if(rowAffected==1){
            System.out.println("creation successfull");
            return "creation successfull";
        }
        else{
            return "Creation failed";
        }

    }

    public String updateStudent(Student student,Long id){
        String sql= """
        update student
        set name=?,
            email=?,
            age=?
        where id=?
        """;
        int rowAffected=jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge(), id);
        if(rowAffected==1) {
            System.out.println("updation successfull.");
            return "updation succssfull";
        }else{
            System.out.println("updation failed");
            return "updation failed";
        }
    }
    public String deleteStudent(Long id){
        String sql= """
               DELETE from student where id=?                
                """;
        int rowAffected=jdbcTemplate.update(sql,id);
        if(rowAffected==1) {
            System.out.println("deletion successfull.");
            return "deletion successfull";
        }else{
            System.out.println("deletion failed");
            return "deletion failed";
        }
    }

    public Student getStudentById(Long id){
        String sql= """
              Select * from student where id=?                
                """;
        return jdbcTemplate.queryForObject(sql,studentRowMapper,id);}//can work with both rowMapper/StudentRowMapper


    public List<Student> getStudents(){
        String sql= """
              Select id, name,email,age from student               
                """;
        List<Student> students=jdbcTemplate.query(sql, rowMapper);//can work with both rowMapper/StudentRowMapper
        return students;
    }

}
