package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;

    private String school;

    private String schoolAddress;

    private String studentID;

    private String classroom;

    private String day;

    private String month;

    private String year;

    private String gender;

    private String placeOfBirth;

    private String ethnicity;

    private String homeAddress;

    private String phoneNumber;

    private int firstGradeScore;

    private int secondGradeScore;

    private int thirdGradeScore;

    private int fourthGradeScore;

    private int fifthGradeScore;

    private int totalFiveGradeScore;

    private int priorityScore;

    private int totalScore;

    private String notes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFirstGradeScore() {
        return firstGradeScore;
    }

    public void setFirstGradeScore(int firstGradeScore) {
        this.firstGradeScore = firstGradeScore;
    }

    public int getSecondGradeScore() {
        return secondGradeScore;
    }

    public void setSecondGradeScore(int secondGradeScore) {
        this.secondGradeScore = secondGradeScore;
    }

    public int getThirdGradeScore() {
        return thirdGradeScore;
    }

    public void setThirdGradeScore(int thirdGradeScore) {
        this.thirdGradeScore = thirdGradeScore;
    }

    public int getFourthGradeScore() {
        return fourthGradeScore;
    }

    public void setFourthGradeScore(int fourthGradeScore) {
        this.fourthGradeScore = fourthGradeScore;
    }

    public int getFifthGradeScore() {
        return fifthGradeScore;
    }

    public void setFifthGradeScore(int fifthGradeScore) {
        this.fifthGradeScore = fifthGradeScore;
    }

    public int getTotalFiveGradeScore() {
        return totalFiveGradeScore;
    }

    public void setTotalFiveGradeScore(int totalFiveGradeScore) {
        this.totalFiveGradeScore = totalFiveGradeScore;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
