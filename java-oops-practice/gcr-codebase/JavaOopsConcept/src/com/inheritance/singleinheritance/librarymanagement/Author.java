package com.inheritance.singleinheritance.librarymanagement;

public class Author extends Book{
	private String name;
	private String bio;
	
	// constructor
	public Author(String title, int publicationYear, String name, String bio) {
		super(title, publicationYear);
		this.name = name;
		this.bio = bio;
	}
	
	// display info
	public void display() {
		System.out.println("Author : " + name + "Book title : " + super.getTitle());
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}	
}