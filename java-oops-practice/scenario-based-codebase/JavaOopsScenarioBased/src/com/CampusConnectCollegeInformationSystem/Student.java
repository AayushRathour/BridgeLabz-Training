package com.CampusConnectCollegeInformationSystem;

class Student extends Person implements ICourseActions {
    private int grade1;
    private int grade2;
    private int grade3;

    Student(String name, String email, int id, int grade1, int grade2, int grade3) {
        super(name, email, id);
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    double calculateGpa() {
        return (grade1 + grade2 + grade3) / 3.0;
    }

    public void enrollCourse() {
        System.out.println(name + " enrolled in course");
    }

    public void dropCourse() {
        System.out.println(name + " dropped course");
    }

    void printDetails() {
        System.out.println("Student Name: " + name + ", GPA: " + calculateGpa());
    }
}
