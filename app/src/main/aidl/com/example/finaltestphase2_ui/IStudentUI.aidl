package com.example.finaltestphase2_ui;

// Declare any non-default types here with import statements
import com.example.finaltestphase2_ui.common.Student;
interface IStudentUI {
    List<Student> get100Students();
    List<Student> getTop10StudentByNameAndScore(String subjectName);
    List<Student> getTop10StudentsByScoreA(String city);
    List<Student> getTop10StudentsByScoreB(String city);
    List<Student> searchStudent(String name, String city);
    Student getStudentByID(int id);
}