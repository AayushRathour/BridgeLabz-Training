package com.UniversityCourseEnrollmentSystem;

public class Undergraduate extends Student implements Graded {
    public Undergraduate(int studentId, String name) {
        super(studentId, name);
    }

    // letter grading
    public void assignGrade(int marks) {
        double gpa = (marks + 10) / 20.0;
        setGpa(gpa);
    }
}