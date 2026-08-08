package com.student.StudentManagementXML;

public class StudentRepository {

    public void saveStudent(Student student) {

        System.out.println("Adding the Student ...");

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Roll No: " + student.getRollNo());
        System.out.println("Student Course: " + student.getCourse());

        System.out.println("Student Added ...");
    }
}
