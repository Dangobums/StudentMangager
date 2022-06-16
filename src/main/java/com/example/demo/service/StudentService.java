package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> searchStudentByStudentName(String query);
    List<Student> searchStudentByStudentID(String query);
}
