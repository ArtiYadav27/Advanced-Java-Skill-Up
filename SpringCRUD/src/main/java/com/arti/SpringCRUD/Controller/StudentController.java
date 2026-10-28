package com.arti.SpringCRUD.Controller;



import com.arti.SpringCRUD.DTOs.CreateReqDto;
import com.arti.SpringCRUD.DTOs.CreateResDto;
import com.arti.SpringCRUD.DTOs.UpdateReqDto;
import com.arti.SpringCRUD.DTOs.UpdateResDto;
import com.arti.SpringCRUD.Entity.Student;
import com.arti.SpringCRUD.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//takes input of rest api as incoming request and outputs in json format
@RequestMapping("/api/Students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<CreateResDto> createStudent(@Valid @RequestBody CreateReqDto studentDto){
//        student.setDeleted(false); // after DTO implementation it should be part of DTO
        CreateResDto createdStudent=studentService.createStudent(studentDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateResDto> getStudent(@PathVariable Long id){
        CreateResDto receivedStudent= studentService.getStudent(id);

//        if(receivedStudent == null){ //condition is being handled by exceptionHandler
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.ok(receivedStudent);

//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(receivedStudent);
    }

    @GetMapping
    public ResponseEntity<List<CreateResDto>> getAllStudent(){
        List<CreateResDto> studentList=studentService.getAllStudents();
//        if(studentList.isEmpty()){ //assuming empty list is also a successfull response
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateResDto> updateStudent(@RequestParam Long id, @RequestBody UpdateReqDto student){
        UpdateResDto studentRes=studentService.updateStudent(id,student);
//        if(student ==null){ //being handled by handleResourceNotFoundException
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);

//        Boolean isDeleted =studentService.deleteStudent(id);
//        if(isDeleted){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //OR
        return  ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();

//        Boolean isDeleted=studentService.deleteStudentSoftly(id);
//        if(isDeleted){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok("Record deleted");
    }
}
