package com.UniversityCourseEnrollmentSystem;

public class Faculty {
    private int facultyId;
    private String name;

    public Faculty(int facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
    }

    public void assignStudentGrade(Graded student, int marks) {
        student.assignGrade(marks);
    }
}