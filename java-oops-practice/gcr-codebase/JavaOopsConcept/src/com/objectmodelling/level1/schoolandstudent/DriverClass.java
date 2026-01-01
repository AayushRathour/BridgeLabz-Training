package com.objectmodelling.level1.schoolandstudent;

public class DriverClass {
	public static void main(String[] args) {
		School school = new School("School name");
		Course course = new Course("B.tech");
		Student student = new Student("student name");
		
		school.addCouse(course);
		student.enrollInCourse(course);
		course.addStudent(student);
		
		student.viewCourses();
		course.viewStudents();
	}
}
