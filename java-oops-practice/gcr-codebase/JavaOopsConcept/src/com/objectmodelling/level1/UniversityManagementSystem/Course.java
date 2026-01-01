package com.objectmodelling.level1.UniversityManagementSystem;

import java.util.ArrayList;

public class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // method to assign professor to course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    // method to add student in course
    public void addStudent(Student student) {
        students.add(student);
    }

    // method to return course name
    public String getCourseName() {
        return name;
    }
}