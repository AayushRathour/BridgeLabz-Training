package com.objectmodelling.level1.UniversityFacultiesandDepartments;

import java.util.ArrayList;
import java.util.List;

public class University {
    String name;
    List<Department> departments;

    // constructor
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // method to add department
    void addDepartment(Department dept) {
        departments.add(dept);
    }

    // print university name and its departments
    void display() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.display();
        }
    }

    // method to delete departments
    void deleteUniversity() {
        System.out.println("Deleting University: " + name);
        departments.clear();
    }
}