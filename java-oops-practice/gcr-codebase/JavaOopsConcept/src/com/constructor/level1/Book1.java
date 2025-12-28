package com.constructor.level1;

public class Book1 {
	public String ISBN;
	protected String title;
	private String author;
	
	// getter for author name
	public String getAuthor() {
		return author;
	}
	
	// setter for author name
	public void setAuthor(String author) {
		this.author = author;
	}
}