package com.arti.SpringCRUD.Repository;


import com.arti.SpringCRUD.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();

    Boolean existsByEmail(String emailId);

}
//dummy data
//    public Student saveStudent(Student studentReq) {
//        //save to db
//        System.out.println("inside student repository");
//        Student s1=new Student();
//        s1.setName("Arti");
//        s1.setAge(26);
//        s1.setEmail("artiyadav@gmail.com");
//        s1.setRollNo(45);
//        s1.setSubject("Spring framework");
//        return s1;
//    }