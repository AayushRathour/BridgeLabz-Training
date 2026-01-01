package com.inheritance.MultilevelInheritance.EducationalCourse;

public class DriverClass {
	public static void main(String[] args) {

		// creating object
        PaidOnlineCourse c1 = new PaidOnlineCourse("Java", 1, "platform1", true, 1000, 1000);

        c1.displayDetails();
    }
}