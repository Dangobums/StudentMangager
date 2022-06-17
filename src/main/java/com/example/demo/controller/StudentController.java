package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    private StudentService
            studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

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
        return studentRepository.findAll();
    }
    @GetMapping("/searchname")
    public ResponseEntity<List<Student>> searchStudentByStudentName(@RequestParam("query") String query) {
        return ResponseEntity.ok(studentService.searchStudentByStudentName(query));
    }
    @GetMapping("/searchid")
    public ResponseEntity<List<Student>> searchStudentByStudentID(@RequestParam("query") String query) {
        return ResponseEntity.ok(studentService.searchStudentByStudentID(query));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentByStudentNameID(@RequestParam(name = "id", required = false) String id, @RequestParam(name ="name", required = false) String name) {
        if (id == null) {
            return ResponseEntity.ok(studentService.searchStudentByStudentName(name));
        } else if (name == null) {
            return ResponseEntity.ok(studentService.searchStudentByStudentName(id));
        }
        else {
            return ResponseEntity.ok(studentService.searchStudentByStudentNameAndID(id, name));
        }
    }
    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for(int i=5; i <=worksheet.getPhysicalNumberOfRows(); i++) {
            //System.out.println("Cell:" + worksheet.getLastRowNum() + " Currently: " + i );
            XSSFRow row = worksheet.getRow(i);
            if (isRowEmpty(row)) {
                break;
            }
            Student tempStudent = new Student();

            for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                switch (j) {
                    case 1 -> tempStudent.setSchool(cell.getStringCellValue());
                    case 2 -> tempStudent.setSchoolAddress(cell.getStringCellValue());
                    case 3 -> tempStudent.setStudentID(row.getCell(3).getStringCellValue());
                    case 4 -> tempStudent.setClassroom(row.getCell(4).getStringCellValue());
                    case 5 -> tempStudent.setStudentName(row.getCell(5).getStringCellValue());
                    case 6 -> tempStudent.setDay((cell.getStringCellValue()));
                    case 7 -> tempStudent.setMonth((cell.getStringCellValue()));
                    case 8 -> tempStudent.setYear((cell.getStringCellValue()));
                    case 9 -> tempStudent.setGender(cell.getStringCellValue());
                    case 10 -> tempStudent.setPlaceOfBirth(cell.getStringCellValue());
                    case 11 -> tempStudent.setEthnicity(cell.getStringCellValue());
                    case 12 -> tempStudent.setHomeAddress(cell.getStringCellValue());
                    case 13 -> tempStudent.setPhoneNumber(cell.getStringCellValue());
                    case 14 -> tempStudent.setFirstGradeScore((int) (cell.getNumericCellValue()));
                    case 15 -> tempStudent.setSecondGradeScore((int) (cell.getNumericCellValue()));
                    case 16 -> tempStudent.setThirdGradeScore((int) (cell.getNumericCellValue()));
                    case 17 -> tempStudent.setFourthGradeScore((int) (cell.getNumericCellValue()));
                    case 18 -> tempStudent.setFifthGradeScore((int) (cell.getNumericCellValue()));
                    case 19 -> tempStudent.setTotalFiveGradeScore((int) (cell.getNumericCellValue()));
                    case 20 -> tempStudent.setPriorityScore((int) (cell.getNumericCellValue()));
                    case 21 -> tempStudent.setTotalScore((int) (cell.getNumericCellValue()));
                    case 22 -> tempStudent.setNotes(cell.getStringCellValue());
                }
            }
            studentRepository.save(tempStudent);
        }
    }
    private static boolean isRowEmpty(Row row) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null) {
            for (Cell cell : row) {
                if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
                    isEmpty = false;
                    break;
                }
            }
        }

        return isEmpty;
    }
}
