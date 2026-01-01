package com.objectmodelling.level1.UniversityFacultiesandDepartments;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Faculty> facultyList; 

    // constructor
    public Department(String name) {
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    // method to add faculty
    void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    // method to print department details
    void display() {
        System.out.println("Department: " + name);
    }
}