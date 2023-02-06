package com.example.demo.course;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;

    @ManyToMany(mappedBy = "linkedCourses")
    @JsonBackReference
    private List<Student> linkedStudents = new ArrayList<>();

    public Course(){

    }

    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Long getcourseId() {
        return courseId;
    }

    public void setcourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        this.linkedStudents.add(student);
    }

    public void removeStudent(Student student) {
        this.linkedStudents.remove(student);
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + courseId +
                ", name=" + courseName +
                "}";
    }
}
