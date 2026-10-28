package com.arti.aopDemo.controller;

import com.arti.aopDemo.dto.Student;
import com.arti.aopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
        this.studentService=studentService;
    }

    @PostMapping
    public Student createStudent(Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod(){
        String s="All Student data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
