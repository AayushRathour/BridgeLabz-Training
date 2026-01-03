package com.UniversityCourseEnrollmentSystem;

public abstract class Student {
    private int studentId;
    private String name;
    private double gpa;

    // normal admission
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = 0.0;
    }

    // admission with elective preference
    public Student(int studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    protected void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getTranscript() {
        return studentId + " " + name + " " + gpa;
    }
}