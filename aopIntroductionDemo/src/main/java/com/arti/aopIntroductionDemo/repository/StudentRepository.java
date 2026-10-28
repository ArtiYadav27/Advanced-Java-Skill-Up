package com.arti.aopIntroductionDemo.repository;

import com.arti.aopIntroductionDemo.dto.Student;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository{

    public void save(Student student) {
        System.out.println("student saved");
    }
}
