package com.arti.springJDBCDemo.controller;

import com.arti.springJDBCDemo.model.Student;
import com.arti.springJDBCDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent=studentService.getAllStudent();
        return ResponseEntity.ok(allStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable Long id){
        String statusMessage=studentService.updateStudent(student,id);
        return ResponseEntity.ok(statusMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        String statusMessage=studentService.deleteStudent(id);
        return ResponseEntity.ok(statusMessage);
    }
}
