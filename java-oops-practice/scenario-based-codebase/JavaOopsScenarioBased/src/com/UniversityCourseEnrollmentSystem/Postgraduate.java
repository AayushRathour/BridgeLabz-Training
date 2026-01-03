package com.UniversityCourseEnrollmentSystem;

public class Postgraduate extends Student implements Graded {
    public Postgraduate(int studentId, String name) {
        super(studentId, name);
    }

    // pass / fail grading
    public void assignGrade(int marks) {
        double gpa;
        if(marks >= 50) gpa = 4.0;
        else gpa = 0.0;
        setGpa(gpa);
    }
}