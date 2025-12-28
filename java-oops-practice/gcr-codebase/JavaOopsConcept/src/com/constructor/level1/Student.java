package com.constructor.level1;

public class Student {

    public int rollNumber;
    protected String name;
    private double CGPA;

    // constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // public getter
    public double getCGPA() {
        return CGPA;
    }

    // public setter
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}
