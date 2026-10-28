package com.arti.hibernateDemo.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="student_entries")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name="student_name",
            nullable = false,
            length = 100
    )
    private String name;
    @Column(
            unique = true,
            nullable = false,
            insertable = true,
            updatable = true,
            length = 150
    )
    private String email;
    private int age;

    @ElementCollection
    @CollectionTable(
            name="student_skills",
            joinColumns = @JoinColumn(name="student_id")
    )
    private Set<String> skills;

    public Student(Long id, String name, String email, int age, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.skills = skills;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    //===============================================================================================================================
//    @Embedded
//    @AttributeOverrides(
//            {@AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "current_house_no")
//            ),
//                    @AttributeOverride(
//                            name = "street",
//                            column = @Column(name = "current_street")
//                    ),
//                    @AttributeOverride(
//                            name = "city",
//                            column = @Column(name = "current_city")
//                    ),
//                    @AttributeOverride(
//                            name = "state",
//                            column = @Column(name = "current_state")
//                    ),
//                    @AttributeOverride(
//                            name = "pincode",
//                            column = @Column(name = "current_pincode")
//                    )}
//    )
//    private Address currentAddress;
//    @Embedded
//    @AttributeOverrides(
//            {@AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "permanent_house_no")
//            ),
//                    @AttributeOverride(
//                            name = "street",
//                            column = @Column(name = "permanent_street")
//                    ),
//                    @AttributeOverride(
//                            name = "city",
//                            column = @Column(name = "permanent_city")
//                    ),
//                    @AttributeOverride(
//                            name = "state",
//                            column = @Column(name = "permanent_state")
//                    ),
//                    @AttributeOverride(
//                            name = "pincode",
//                            column = @Column(name = "permanent_pincode")
//                    )}
//    )
//    private Address permanentAddress;
//
//    public Student(Long id, String name, String email, int age, Address currentAddress, Address permanentAddress) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.currentAddress = currentAddress;
//        this.permanentAddress = permanentAddress;
//    }
//
//    public Student() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }
//
//    public Address getPermanentAddress() {
//        return permanentAddress;
//    }
//
//    public void setPermanentAddress(Address permanentAddress) {
//        this.permanentAddress = permanentAddress;
//    }

    //-----------------------------------------------------------------------------------
    //    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//    private LocalDate dateOfBirth;
//    private LocalDateTime createdAt;
//
//    @Column(precision = 5, scale = 2)
//    private BigDecimal percentage;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private Boolean isMoniter;
//
//    @Transient
//    private String isDisplay;
//    public Student() {
//    }
//
//    public Student(Long id, String name,
//                   String email,
//                   int age,
//                   StudentStatus status,
//                   LocalDate dateOfBirth,
//                   LocalDateTime createdAt,
//                   BigDecimal percentage,
//                   Boolean isMoniter,
//                   String isDisplay) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.status = status;
//        this.dateOfBirth = dateOfBirth;
//        this.createdAt = createdAt;
//        this.percentage = percentage;
//        this.isMoniter = isMoniter;
//        this.isDisplay = isDisplay;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public BigDecimal getPercentage() {
//        return percentage;
//    }
//
//    public void setPercentage(BigDecimal percentage) {
//        this.percentage = percentage;
//    }
//
//    public Boolean getMoniter() {
//        return isMoniter;
//    }
//
//    public void setMoniter(Boolean moniter) {
//        isMoniter = moniter;
//    }
//
//    public String getIsDisplay() {
//        return isDisplay;
//    }
//
//    public void setIsDisplay(String isDisplay) {
//        this.isDisplay = isDisplay;
//    }
}
