package com.inheritance.MultilevelInheritance.EducationalCourse;

public class Course {
    public String courseName;
    int duration;

    // constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // display
    public void displayDetails() {
        System.out.println(courseName + " " + duration);
    }
}