package com.example.demo.course;

import com.example.demo.dto.BaseRespond;
import com.example.demo.dto.StudentInfoDTO;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void removeCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }

//    public StudentInfoDTO convertEntityToDTO(Student student){
//        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
//        studentInfoDTO.setStudentId(student.getStudentId());
//        studentInfoDTO.setName(student.getName());
//        return null;
//    }
    public BaseRespond findStudents(Long cid) {
        Optional<Course> courseOptional = courseRepository.findById(cid);
        BaseRespond br = new BaseRespond();
        if(courseOptional.isPresent()){
            br.setMessage("Thanh cong");
            br.setCode(1);
            List<Student> students = courseOptional.get().getLinkedStudents();
            List<StudentInfoDTO> studentInfoDTOList = students.stream().map(student -> modelMapper.map(student, StudentInfoDTO.class)).collect(Collectors.toList());
            br.setData(studentInfoDTOList);
        } else {
            br.setMessage("Khong tim thay course");
            br.setCode(2);
        }

        return br;
    }
}
