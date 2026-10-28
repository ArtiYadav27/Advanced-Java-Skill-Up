package com.arti.aopIntroductionDemo.service;


import com.arti.aopIntroductionDemo.LoggingServiceUtil;
import com.arti.aopIntroductionDemo.dto.Student;
import com.arti.aopIntroductionDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public void createStudent(Student student){
//        LoggingServiceUtil.logStart("StudentService","createStudent");
        System.out.println("Student saved successfully");
        studentRepository.save(student);
//        LoggingServiceUtil.logEnd("StudentService","createStudent");
    }
}

