package com.arti.SpringCRUD.Service;

import com.arti.SpringCRUD.DTOs.CreateReqDto;
import com.arti.SpringCRUD.DTOs.CreateResDto;
import com.arti.SpringCRUD.DTOs.UpdateReqDto;
import com.arti.SpringCRUD.DTOs.UpdateResDto;
import com.arti.SpringCRUD.Entity.Student;
import com.arti.SpringCRUD.Exception.DuplicateResourceException;
import com.arti.SpringCRUD.Exception.ResourceNotFoundException;
import com.arti.SpringCRUD.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateResDto createStudent(CreateReqDto studentReqDto){
        //all validations and business logic
        Student student=maptoEntity(studentReqDto);
        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email " + student.getEmail()+ "already exists");
        }

        Student stuRes=studentRepository.save(student);

        return mapToDto(stuRes);

    }

    public CreateResDto getStudent(Long id){
        Student studentRes=studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id "+ id + " not found"));

        return mapToDto(studentRes);


//        Optional<Student> studentResp=studentRepository.findById(id);
//        Optional<Student> studentResp=studentRepository.findByIdAndDeletedIsFalse(id);
//        return studentResp.map(this::mapToDto).orElse(null);

//        if(studentResp.isPresent()){
//            return mapToDto(studentResp.get());
//        }
//        else{
//            return null;
//        }
    }

    public List<CreateResDto> getAllStudents(){
        List<Student> allStudent=studentRepository.findByDeletedIsFalse();

        return allStudent.stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateResDto updateStudent(Long id, UpdateReqDto student){
//        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
//        if(existingStudent.isEmpty()){
//            return null;
//        }
//        Student studentToSave=existingStudent.get();

        Student studentToSave=studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));

        studentToSave.setSubject(student.getSubject());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setName(student.getName());
        studentToSave.setAge(student.getAge());
        studentToSave.setDeleted(false);//optional-not necessary here
        Student res=studentRepository.save(studentToSave);
        return updateMapToDto(res);
    }


    public void deleteStudent(Long id){
        Student student=studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));


        studentRepository.delete(student);


//        Boolean isStudent=studentRepository.existsById(id);
//
//        if(!isStudent)return false;
//
//        studentRepository.deleteById(id);
//        return true;
    }

    public void deleteStudentSoftly(Long id){
        Student student=studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));

        student.setDeleted(true);
        studentRepository.save(student);

//        Optional<Student> existingStudent =studentRepository.findByIdAndDeletedIsFalse(id);
//        if(existingStudent.isEmpty())return false;
//
//        Student studentToDelete=existingStudent.get();
//        studentToDelete.setDeleted(true);
//        studentRepository.save(studentToDelete);
//        return true;
    }

    private Student maptoEntity(CreateReqDto req){
        Student student=new Student();
        student.setName(req.getName());
        student.setAge(req.getAge());
        student.setRollNo(req.getRollNo());
        student.setEmail(req.getEmail());
        student.setSubject(req.getSubject());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateResDto mapToDto(Student student){
        CreateResDto res=new CreateResDto();
        res.setId(student.getId());
        res.setAge(student.getAge());
        res.setName(student.getName());
        res.setEmail(student.getEmail());
        res.setRollNo(student.getRollNo());
        res.setCreatedAt(student.getCreatedAt());
        res.setSubject(student.getSubject());
        res.setMessage("Student record saved successfully..");
        return res;
    }

    private UpdateResDto updateMapToDto(Student student){
        UpdateResDto res=new UpdateResDto();
        res.setId(student.getId());
        res.setAge(student.getAge());
        res.setName(student.getName());
        res.setEmail(student.getEmail());
        res.setRollNo(student.getRollNo());
        res.setSubject(student.getSubject());
        res.setMessage("Student record updated successfully.");
        return res;
    }

    private Boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}
