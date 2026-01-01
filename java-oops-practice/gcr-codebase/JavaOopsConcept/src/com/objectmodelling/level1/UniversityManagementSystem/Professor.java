package com.objectmodelling.level1.UniversityManagementSystem;

public class Professor {
    private int id;
    private String name;

    // constructor
    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // return name
    public String getProfessorName() {
        return name;
    }
}
