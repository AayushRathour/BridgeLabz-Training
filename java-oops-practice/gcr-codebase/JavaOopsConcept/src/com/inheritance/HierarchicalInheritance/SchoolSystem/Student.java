package com.inheritance.HierarchicalInheritance.SchoolSystem;

public class Student extends Person {
    public String grade;

    // constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // display details
    public void displayRole() {
        System.out.println("Student : " + " Grade: " + grade);
    }
}