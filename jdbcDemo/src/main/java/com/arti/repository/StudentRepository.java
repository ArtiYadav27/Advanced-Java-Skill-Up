package com.arti.repository;

import com.arti.modal.Student;
import java.sql.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    String url="jdbc:mysql://localhost:3306/user";
    String username="root";
    String password="pass";


    public void createStudent(Student student){
//        String sql="Insert into student(name, email, age) values('arti','artiyadav@gmail.com',45)";

//        String sql= """
//        Insert into student(name,email,age) values('%s','%s',%d)
//        """.formatted(student.getName(),student.getEmail(), student.getAge());

        String sql= """
        insert into student(name,email,age) values(?,?,?)
        """;
//        try {
//            Connection connection= DriverManager.getConnection(url,username,password);
//            Statement statement=connection.createStatement();
//            int result=statement.executeUpdate(sql);
//            if(result==1) {
//                System.out.println("Creation successfull.");
//            }else{
//                System.out.println("creation failed");
//            }
//            connection.close();
//        }

        try(Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);)
        {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());

            int rowAffected=preparedStatement.executeUpdate();
            if(rowAffected==1){
                System.out.println("creation successfull");

            }
            else{
                System.out.println("creation failer");
            }
        }
        catch (SQLException e){
            System.out.println("connection failed.");
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student,Long id){
        String sql= """
        update student
        set name=?,
            email=?,
            age=?
        where id=?
        """;
        try(Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);)
        {
//            Connection connection= DriverManager.getConnection(url,username,password);
//            Statement statement=connection.createStatement();
//            String sql="update student set age=28 where id=2";
//            int result=statement.executeUpdate(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,id);
            int rowAffected=preparedStatement.executeUpdate();
            if(rowAffected==1) {
                System.out.println("updation successfull.");
            }else{
                System.out.println("creation failed");
            }
//            connection.close();
        }
        catch (SQLException e){
            System.out.println("connection failed.");
            e.printStackTrace();
        }
    }
    public void deleteStudent(Long id){
        String sql= """
               DELETE from student where id=?                
                """;
        try(Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);)
        {
//            Connection connection= DriverManager.getConnection(url,username,password);
//            Statement statement=connection.createStatement();
//            String sql="DELETE from student where id=2";
//            int rowAffected=statement.executeUpdate(sql);

            preparedStatement.setLong(1,id);
            int rowAffected=preparedStatement.executeUpdate();
            if(rowAffected==1) {
                System.out.println("deletion successfull.");
            }else{
                System.out.println("deletion failed");
            }
//            connection.close();
        }
        catch (SQLException e){
            System.out.println("connection failed.");
            e.printStackTrace();
        }
    }

    public void getStudentById(Long id){
        String sql= """
              Select * from student where id=?                
                """;
        try(Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);)
        {
//            Connection connection= DriverManager.getConnection(url,username,password);
//            Statement statement=connection.createStatement();
//            String sql="select * from student";
//            ResultSet resultSet=statement.executeQuery(sql);


            preparedStatement.setLong(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                if(resultSet.next()){
                    Student student=mapRow(resultSet);
                    System.out.println(student);
                }
            }
        }
        catch (SQLException e){
            System.out.println("connection failed.");
            e.printStackTrace();
        }
    }

    public void getStudents(){
        String sql= """
              Select id, name,email,age from student               
                """;
        try(Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);)
        {
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                List<Student> studentList=new ArrayList<>();
                while(resultSet.next()){
                    Student student=mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
            }
        }
        catch (SQLException e){
            System.out.println("connection failed.");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultset) throws SQLException {
        Student student=new Student();
        student.setId(resultset.getLong("id"));
        student.setName(resultset.getString("name"));
        student.setEmail(resultset.getString("email"));
        student.setAge(resultset.getInt("age"));
        return student;
    }

}
