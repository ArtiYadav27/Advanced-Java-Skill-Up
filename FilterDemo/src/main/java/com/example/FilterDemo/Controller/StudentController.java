package com.example.FilterDemo.Controller;


import com.example.FilterDemo.Dtos.StudentResponseDto;
import com.example.FilterDemo.Service.StudentService;
import com.example.FilterDemo.Dtos.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody Student student){
        StudentResponseDto res=studentService.createStudent(student);
        return ResponseEntity.ok(res);
    }
}
