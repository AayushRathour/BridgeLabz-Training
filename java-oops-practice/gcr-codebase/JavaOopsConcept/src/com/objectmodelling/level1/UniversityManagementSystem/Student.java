package com.objectmodelling.level1.UniversityManagementSystem;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private ArrayList<Course> courses;

    // constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // method to enroll in course
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    // get student name
    public String getStudentName() {
        return name;
    }
}