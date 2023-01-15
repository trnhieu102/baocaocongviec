package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {

        return studentRepository.findAll();

    }

    public Student getByStudentId(Integer studentId){
        Optional<Student> getStudentOptional = studentRepository.findByStudentId(studentId);

        if (getStudentOptional.isEmpty()){
            throw new RuntimeException("Cannot find student with given Id");
        }
        return getStudentOptional.get();
    }

    public void addStudent(Student student){
        Optional<Student> addStudentOptional = studentRepository.findByStudentId(student.getStudentId());
        if (addStudentOptional.isPresent()){
            throw new RuntimeException("Student Id already exists");
        }
        studentRepository.save(student);
    }

    @Transactional
    public void removeByStudentId(Integer studentId){

        Optional<Student> deleteStudentOptional = studentRepository.findByStudentId(studentId);

        if (deleteStudentOptional.isEmpty()){
            throw new RuntimeException("Cannot find student with given Id");
        }
//        studentRepository.deleteBy(studentId);
        studentRepository.deleteByStudentId(studentId);
    }

    @Transactional
    public void putStudentById(Integer studentId, String name, LocalDate dob, String sex){

        Student student = studentRepository.findByStudentId(studentId).
                orElseThrow(()-> new RuntimeException("Student with id " + studentId + "does not exist"));

        if (name != null && !Objects.equals(name, student.getName())){
            student.setName(name);
        }

        if (dob != null && !Objects.equals(dob, student.getDob())){
            student.setDob(dob);
        }

        if (sex != null && !Objects.equals(sex, student.getSex())){
            student.setSex(sex);
        }
    }
}

