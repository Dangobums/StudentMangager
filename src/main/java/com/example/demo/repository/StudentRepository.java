package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT stu from Student stu WHERE " + "stu.studentName LIKE  concat('%', :query, '%') ")
    List<Student> searchStudentByStudentName(String query);
    @Query("SELECT stu from Student stu WHERE " + "stu.studentID LIKE  concat('%', :query, '%')")
    List<Student> searchStudentByStudentID(String query);

    @Query("SELECT stu from Student stu WHERE " + "stu.studentID LIKE  concat('%', :id, '%') OR stu.studentName like concat('%', :name, '%') ")
    List<Student> searchStudentByStudentNameOrID(String id , String name);

    @Query("SELECT stu from Student stu WHERE " + "stu.studentID LIKE  concat('%', :id, '%') AND stu.studentName like concat('%', :name, '%') ")
    List<Student> searchStudentByStudentNameAndID(String id , String name);
}
