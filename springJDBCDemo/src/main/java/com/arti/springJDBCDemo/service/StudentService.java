package com.arti.springJDBCDemo.service;

import com.arti.springJDBCDemo.model.Student;
import com.arti.springJDBCDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public String createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public List<Student> getAllStudent() {
        List<Student> allStudent=studentRepository.getStudents();
        return allStudent;
    }

    public Student getStudentById(Long id) {
        Student student=studentRepository.getStudentById(id);
        return student;
    }

    public String updateStudent(Student student,Long id) {
        return studentRepository.updateStudent(student,id);
    }

    public String deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }
}
