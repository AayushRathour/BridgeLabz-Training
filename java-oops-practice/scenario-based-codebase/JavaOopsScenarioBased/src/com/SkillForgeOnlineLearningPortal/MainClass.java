package com.SkillForgeOnlineLearningPortal;

public class MainClass {
	public static void main(String[] args) {
		Instructor instructor = new Instructor(0, "Instructor 1", "Java", 5);
		Course course = new Course("Java fundamentals", 4.0, instructor);
		
		System.out.println(course.modules);
		
		Student student = new Student(1, "Student 1", course, 4, 0);
		
		student.completeModule();
		student.completeModule();
		
		student.showProgress();
		
		student.completeModule();
		student.completeModule();
	}
}