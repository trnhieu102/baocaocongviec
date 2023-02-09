package com.example.demo.dto;

public class StudentInfoDTO {
    private String name;
    private Integer studentId;

    public StudentInfoDTO(){}

    public StudentInfoDTO(String name, Integer studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentInfoDTO{" +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
