package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);

    }
    @GetMapping("/studentslist")
    public List<Student> getStudentLists() {
        return (List<Student>) studentRepository.findAll();
    }
    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

//        for(int i=5;i<worksheet.getPhysicalNumberOfRows() ;i++) {
        Student tempStudent = new Student();

        XSSFRow row = worksheet.getRow(5);
//        row.getCell(6).getCellType();
        System.out.println(row.getCell(6).getCellType());
        tempStudent.setSchool(row.getCell(1).getStringCellValue());
        tempStudent.setSchoolAddress(row.getCell(2).getStringCellValue());
        tempStudent.setStudentID(row.getCell(3).getStringCellValue());
        tempStudent.setClassroom(row.getCell(4).getStringCellValue());
        tempStudent.setStudentName(row.getCell(5).getStringCellValue());
//        tempStudent.setDay((int) (row.getCell(6).getNumericCellValue()));
//        tempStudent.setMonth((int) (row.getCell(7).getNumericCellValue()));
//        tempStudent.setYear((int) (row.getCell(8).getNumericCellValue()));
        tempStudent.setDay("12");
        tempStudent.setMonth("12");
        tempStudent.setYear("2022");
        tempStudent.setGender(row.getCell(9).getStringCellValue());
        tempStudent.setPlaceOfBirth(row.getCell(10).getStringCellValue());
        tempStudent.setEthnicity(row.getCell(11).getStringCellValue());
        tempStudent.setHomeAddress(row.getCell(12).getStringCellValue());
        tempStudent.setPhoneNumber(row.getCell(13).getStringCellValue());
        tempStudent.setFirstGradeScore((int) (row.getCell(14).getNumericCellValue()));
        tempStudent.setSecondGradeScore((int) (row.getCell(15).getNumericCellValue()));
        tempStudent.setThirdGradeScore((int) (row.getCell(16).getNumericCellValue()));
        tempStudent.setFourthGradeScore((int) (row.getCell(17).getNumericCellValue()));
        tempStudent.setFifthGradeScore((int) (row.getCell(18).getNumericCellValue()));
        tempStudent.setTotalFiveGradeScore((int) (row.getCell(19).getNumericCellValue()));
        tempStudent.setPriorityScore((int) (row.getCell(20).getNumericCellValue()));
        tempStudent.setTotalScore((int) (row.getCell(21).getNumericCellValue()));
        tempStudent.setNotes(row.getCell(22).getStringCellValue());
        studentRepository.save(tempStudent);

//        }
    }
}
