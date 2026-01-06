package com.CampusConnectCollegeInformationSystem;

public class MainClass{
    public static void main(String[] args) {

        Student student = new Student("Aayush", "a@gmail.com", 101, 8, 9, 7);
        Faculty faculty = new Faculty("Dr Rao", "r@gmail.com", 201);

        Course course = new Course("Java Programming", faculty);

        student.enrollCourse();
        student.printDetails();
        faculty.printDetails();
    }
}
