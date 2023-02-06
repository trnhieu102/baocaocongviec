package com.example.demo.student;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")

public class StudentController {

    //DI: Dependency Injection
    @Autowired
    private  StudentService studentService;

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @GetMapping("/{studentId}")
    Student StudentById(@PathVariable Integer studentId){
        return studentService.getByStudentId(studentId);
    }

    @PostMapping("/add")
    public void registerStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Integer studentId){
        studentService.removeByStudentId(studentId);
    }

    @PutMapping("/put/{studentId}")
    public void updateStudentById(@PathVariable("studentId") Integer studentId,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "dob", required = false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dob,
                                  @RequestParam(value = "sex", required = false) String sex){
        studentService.putStudentById(studentId, name, dob, sex);
    }

    @GetMapping("/{studentId}/courses")
    public void viewCourses(@PathVariable("studentId") Integer studentId) {
        studentService.viewCoursesByStudentId(studentId);
    }

    @GetMapping("/{studentId}/addCourse")
    public void addCourseToStudent(@PathVariable("studentId") Integer studentId, @RequestParam(value = "courseId") Long courseId){
        studentService.addCourseToStudentId(studentId, courseId);
    }

    @GetMapping("/{studentId}/removeCourse")
    public void removeCourseFromStudent(@PathVariable("studentId") Integer studentId, @RequestParam(value = "courseId") Long courseId){
        studentService.removeCourseFromStudentId(studentId, courseId);
    }
}
