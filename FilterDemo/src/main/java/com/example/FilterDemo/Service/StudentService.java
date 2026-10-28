package com.example.FilterDemo.Service;

import com.example.FilterDemo.Dtos.Student;
import com.example.FilterDemo.Dtos.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto res = new StudentResponseDto();
        res.setName(student.getName());
        res.setMessage("student is saved successfully");
        return res;
    }
}