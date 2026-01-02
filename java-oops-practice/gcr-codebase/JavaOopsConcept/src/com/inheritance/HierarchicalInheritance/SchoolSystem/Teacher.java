package com.inheritance.HierarchicalInheritance.SchoolSystem;

public class Teacher extends Person {
    public String subject;

    // constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // display
    public void displayRole() {
        System.out.println("Teacher : " + subject);
    }
}
