package com.example.demo.student;

import com.example.demo.course.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference
    private List<Course> linkedCourses = new ArrayList<>();

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

    public List<Course> getLinkedCourses() {
        return linkedCourses;
    }

    public void addCourse(Course course) {
        this.linkedCourses.add(course);
    }

    public void removeCourse(Course course) {
        this.linkedCourses.remove(course);
    }

    public void setLinkedCourses(List<Course> linkedCourses) {
        this.linkedCourses = linkedCourses;
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
