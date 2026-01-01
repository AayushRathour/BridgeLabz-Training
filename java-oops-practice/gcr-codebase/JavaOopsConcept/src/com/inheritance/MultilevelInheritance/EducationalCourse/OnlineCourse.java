package com.inheritance.MultilevelInheritance.EducationalCourse;

public class OnlineCourse extends Course {
    public String platform;
    public boolean isRecorded;

    // constructor
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // display
    public void displayDetails() {
        super.displayDetails();
        System.out.println(platform + " " + isRecorded);
    }
}