package com.arti.aopDemo.aspect;


import com.arti.aopDemo.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Aspect
public class LoggingAspect {
//
//    @Before("execution(String com.arti.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(){
//        System.out.println("Student request logged successfully");
//    }


//    @Before("execution(String com.arti.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint){//JoinPoint holds target method
//        System.out.println("Student request logged successfully");
//        Object[] arr=joinPoint.getArgs();//return all the target Method arguments in array
//    }


//    @AfterReturning(value = "execution(com.arti.aopDemo.dto.Student com.arti.aopDemo.service.StudentService.createStudent(com.arti.aopDemo.dto.Student))",
//            returning = "result")OR



//    @AfterReturning(value = "execution(* com.arti.aopDemo.service.StudentService.createStudent(..))",
//        returning = "result")
//    public void logAfterReturningMethod(Student result){
/// /        System.out.println("Log after returning method called:"+ result);
///
/// @return
//        result.setAge(32);
//        result.setName("pihu");
//        return;//return statement from aspect will remain unreachable, controller doesn't accept return from aspect.
//    }



//    @AfterThrowing(value = "execution(* com.arti.aopDemo.service.StudentService.createStudent(..))",
//    throwing = "exception")
//    public void logAfterReturningMethod(Exception exception){
//            System.out.println("An exception occurred.");
//        System.out.println("Exception type:"+ exception.getClass().getName());
//        System.out.println("Exception type:"+ exception.getClass().getTypeName());
//        System.out.println("Exception type:"+ exception.getMessage());
//    }



//    @After("execution(* com.arti.aopDemo.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("logging after method");
//    }



//    @Around("execution(* com.arti.aopDemo.service.StudentService.createStudent(..))")
//    public Object logAfterMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Before target method");
////        Student student=(Student) proceedingJoinPoint.proceed();
////        student.setName("Pihu");
////        student.setAge(23);
////        System.out.println("After target Method");
////        return student;
//
//        try {
//            Object result =proceedingJoinPoint.proceed();
//            System.out.println("execcution successfull");
//            return result;
//        }
//        catch (Exception e){
//            System.out.println("Execution Failer:"+ e.getMessage());
//            throw e;
//        }
//        finally {
//            System.out.println("Execution Completed");
//        }
//    }


//    @Around("execution(* com.arti.aopDemo.service.StudentService.getStudent(..))")
//    public Object logAfterMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Before target method");
//        Object[] arr=proceedingJoinPoint.getArgs();
//        String originalString=(String) arr[0];
//        String modifiedString=originalString.toUpperCase();
//        Object[] modifiedArr={modifiedString};
//        return proceedingJoinPoint.proceed(modifiedArr);
//    }
}