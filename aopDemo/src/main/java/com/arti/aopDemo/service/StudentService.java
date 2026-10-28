package com.arti.aopDemo.service;

import com.arti.aopDemo.annotation.TrackExecutionTime;
import com.arti.aopDemo.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "New student saved"
    )
    public Student createStudent(Student student){
        System.out.println(" Student created");
        try{
            throw new RuntimeException("some error occurred..");
        }
        catch (Exception e){}//when exception occured and catched on service class, proxy doesn't terminate the execution and inthis scenario AfterReturning advice is executed.
//        return "Student saved successfully.";


//        throw new RuntimeException("exception in service class");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get students"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){}
        System.out.println(s);
        return s;
    }

}
