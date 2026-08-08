package com.student.StudentManagementXML;

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {

        this.repository = repository;

        System.out.println("StudentService Object Created");
    }

    public void registerStudent(Student student) {

        System.out.println("Checking Student Details...");

        repository.saveStudent(student);

    }

}
