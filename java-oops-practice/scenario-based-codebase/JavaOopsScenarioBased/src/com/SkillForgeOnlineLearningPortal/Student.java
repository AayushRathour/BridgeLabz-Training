package com.SkillForgeOnlineLearningPortal;

public class Student extends User{
	public Course course;
	public double grading;
	public int progress;
	
	public Student(int id, String name, Course course, double grading, int progress) {
		super(id, name);
		this.course = course;
		this.grading = grading;
		this.progress = progress;
	}
	
	public void completeModule() {
		progress++;
		if(course.modules.size() == progress) course.generateCertificate();
	}
	
	public void showProgress() {
		System.out.println(progress + " modules completed of " + course.modules.size());
	}
}