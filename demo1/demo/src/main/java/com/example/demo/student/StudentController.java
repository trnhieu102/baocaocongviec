package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")

public class StudentController {

    //DI: Dependency Injection
    @Autowired
    private  StudentService studentService;


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
}
