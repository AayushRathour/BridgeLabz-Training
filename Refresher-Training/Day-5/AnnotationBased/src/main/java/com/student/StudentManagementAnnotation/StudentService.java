package com.student.StudentManagementAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository repository;

 // @Autowired is optional here (Spring auto-detects a single constructor
    @Autowired
    public StudentService(StudentRepository repository) {

        this.repository = repository;

        System.out.println("StudentService Object Created");
    }

    public void registerStudent(Student student) {

        System.out.println("Checking Student Details...");

        repository.saveStudent(student);

    }

}
