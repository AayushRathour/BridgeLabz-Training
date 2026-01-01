package com.inheritance.singleinheritance.librarymanagement;

public class Book {
	private String title;
	private int publicationYear;
	
	// constructor
	public Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}
	// getter and setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
}