package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.findAllCourses();
    };

    @GetMapping("/{courseId}")
    Course getCourseById(@PathVariable("courseId") Long courseId){
        return courseService.findCourseById(courseId);
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody Course course){
        courseService.saveCourse(course);
    }

    @DeleteMapping("/delete/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.removeCourse(courseId);
    }
}
