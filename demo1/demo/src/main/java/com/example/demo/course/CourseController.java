package com.example.demo.course;

import com.example.demo.dto.BaseRespond;
import com.example.demo.dto.StudentInfoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

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

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.removeCourse(courseId);
    }

    @GetMapping("/{courseId}/students")
    public BaseRespond getLinkedStudents(@PathVariable("courseId") Long cid){

        return courseService.findStudents(cid);
    }
}
