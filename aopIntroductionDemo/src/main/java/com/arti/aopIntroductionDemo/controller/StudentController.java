package com.arti.aopIntroductionDemo.controller;
import com.arti.aopIntroductionDemo.dto.Student;
import com.arti.aopIntroductionDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }
}
