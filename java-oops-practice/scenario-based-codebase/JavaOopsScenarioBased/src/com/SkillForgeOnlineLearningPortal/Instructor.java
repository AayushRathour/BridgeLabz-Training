package com.SkillForgeOnlineLearningPortal;

public class Instructor extends User{
	public String subject;
	private int yearOfExp;
	
	public Instructor(int id, String name, String subject, int yearOfExp) {
		super(id, name);
		this.subject = subject;
		this.yearOfExp = yearOfExp;
	}

	public int getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(int yearOfExp) {
		this.yearOfExp = yearOfExp;
	}
}