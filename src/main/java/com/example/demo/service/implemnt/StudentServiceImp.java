package com.example.demo.service.implemnt;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> searchStudentByStudentName(String query) {
        List<Student> students =  studentRepository.searchStudentByStudentName(query);
        return students;
    }

    @Override
    public List<Student> searchStudentByStudentID(String query) {
        List<Student> students =  studentRepository.searchStudentByStudentID(query);
        return students;
    }
}
