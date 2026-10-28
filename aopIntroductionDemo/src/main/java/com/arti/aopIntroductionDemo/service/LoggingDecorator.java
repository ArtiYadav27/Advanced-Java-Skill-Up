package com.arti.aopIntroductionDemo.service;

import com.arti.aopIntroductionDemo.LoggingServiceUtil;
import com.arti.aopIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService{
    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }
    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.logStart("StudentService","createStudent");
        studentServiceImpl.createStudent(student);
        LoggingServiceUtil.logEnd("StudentService","createStudent");
    }
}
