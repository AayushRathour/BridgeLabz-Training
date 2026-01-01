package com.objectmodelling.level1.UniversityFacultiesandDepartments;

public class DriverClass {
	public static void main(String[] args) {
        // creating objects of each class
        Faculty f1 = new Faculty("Faculty 1");
        Faculty f2 = new Faculty("Faculty 2");
        University uni = new University("University 1");

        Department cs = new Department("Computer Science");
        Department math = new Department("Mathematics");

        cs.addFaculty(f1);
        math.addFaculty(f2);

        uni.addDepartment(cs);
        uni.addDepartment(math);

        // Display structure
        uni.display();
        uni.deleteUniversity();

        // Faculty still exists independently
        System.out.println("Faculty after University deletion:");
        f1.display();
        f2.display();
	}
}