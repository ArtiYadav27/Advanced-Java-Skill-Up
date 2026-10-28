package com.arti;

import com.arti.modal.Student;
import com.arti.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args){

        StudentRepository studentRepository=new StudentRepository();
//        studentRepository.createStudent(new Student("arti","arti@gmail.com",21));
//        studentRepository.updateStudent(new Student("RT","artiyadav@gmail.com",38),4L);
//        studentRepository.deleteStudent(6L);
//        studentRepository.getStudentById(5L);
        studentRepository.getStudents();
    }

}