package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.studentId = ?1")
    Optional<Student> findByStudentId(Integer studentId);

//    @Modifying
//    @Query("DELETE FROM Student s WHERE s.studentId = ?1")
//    void deleteBy(Integer studentId);

    List<Student> deleteByStudentId(Integer studentId);

}
