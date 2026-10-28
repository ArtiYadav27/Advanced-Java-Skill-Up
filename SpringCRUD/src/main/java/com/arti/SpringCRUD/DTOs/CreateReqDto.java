package com.arti.SpringCRUD.DTOs;

import jakarta.validation.constraints.*;

public class CreateReqDto {
    @NotBlank(message = "name cannot be empty/blank or null")
    @Size(min = 2, max = 50, message = "student name must be within 2 -50 characters long")
    private String name;
    @Min(value = 18)
    private int age;
    @Email
    private String email;
    @NotNull(message = "Roll No is mandatory")
    private Integer rollNo;
    @NotBlank
    private String subject;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
