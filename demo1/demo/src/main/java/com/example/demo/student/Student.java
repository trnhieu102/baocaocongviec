package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dob;
    private String sex;
    private Integer studentId;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String sex, Integer studentId) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.studentId = studentId;
    }

    public Student(String name, LocalDate dob, String sex, Integer studentId) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.studentId = studentId;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) { this.age = age; }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", sex='" + sex + '\'' +
                ", studentId=" + studentId +
                ", age=" + age +
                '}';
    }
}
