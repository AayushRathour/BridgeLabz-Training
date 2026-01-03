package com.UniversityCourseEnrollmentSystem;

public class MainClass {
    public static void main(String[] args) {
        Student ug = new Undergraduate(1, "Aman");
        Student pg = new Postgraduate(2, "Tarun");

        Course course = new Course(101, "OOPS");

        Faculty faculty = new Faculty(11, "Faculty1");

        faculty.assignStudentGrade((Graded) ug, 78);
        faculty.assignStudentGrade((Graded) pg, 42);

        Enrollment e1 = new Enrollment(ug, course);
        Enrollment e2 = new Enrollment(pg, course);

        e1.displayEnrollment();
        e2.displayEnrollment();
    }
}