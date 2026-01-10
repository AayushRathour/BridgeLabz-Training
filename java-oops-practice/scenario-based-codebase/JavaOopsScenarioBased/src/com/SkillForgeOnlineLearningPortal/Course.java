package com.SkillForgeOnlineLearningPortal;

import java.util.List;

public class Course implements ICertifiable{
	public String title;
	public List<String> modules;
	private double rating;
	public Instructor instructor;
	
	public Course(String title, double rating, Instructor instructor, List<String> modules) {
		this.title = title;
		this.modules = modules;
		this.rating = rating;
		this.instructor = instructor;
		this.instructor = instructor;
	}
	
	public Course(String title, double rating, Instructor instructor) {
		this.title = title;
		this.modules = List.of("Introduction", "Theory", "Pratical", "Exam");;
		this.rating = rating;
		this.instructor = instructor;
		this.instructor = instructor;
	}

	public void generateCertificate() {
		System.out.println("Completed certificate for " + title);
	}
	
	public double getRating() {
		return this.rating;
	}
}