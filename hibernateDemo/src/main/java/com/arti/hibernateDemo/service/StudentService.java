package com.arti.hibernateDemo.service;

import com.arti.hibernateDemo.model.Student;
import com.arti.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

//    public List<Student> getAllStudent() {
//        List<Student> allStudent=studentRepository.getStudents();
//        return allStudent;
//    }

    @Transactional
    public Student getStudentById(Long id) {
        Student student=studentRepository.findById(id);
        return student;
    }

    @Transactional
    public String updateStudent(Student student,Long id) {
        Student student1= studentRepository.findById(id);
        if(student1==null){
            System.out.println("student not found");
            return "student does not exists";
        }
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        return "updation successfull";
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student=studentRepository.findById(id);
        if(student==null){
            System.out.println("student not found");
            return;
        }
        studentRepository.remove(student);
    }
}