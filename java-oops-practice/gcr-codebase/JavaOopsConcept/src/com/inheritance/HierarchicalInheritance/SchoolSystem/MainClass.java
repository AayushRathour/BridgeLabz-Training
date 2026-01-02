package com.inheritance.HierarchicalInheritance.SchoolSystem;

public class MainClass {
	public static void main(String[] args) {
		// creating object
        Teacher teacher = new Teacher("Teacher 1", 25, "IP");
        Student student = new Student("Student 1", 20, "12");
        Staff staff = new Staff("Staff 1", 30, "Management");

        teacher.displayDetails();
        teacher.displayRole();
        staff.displayDetails();
        staff.displayRole();
        student.displayDetails();
        student.displayRole();
    }
}
