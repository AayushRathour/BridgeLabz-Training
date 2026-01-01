package com.objectmodelling.level1.librarymanagementsystem;

public class LibaryBook {
	public LibaryBook(LibaryBook b1, LibaryBook b2) {
	// TODO Auto-generated constructor stub
	}

	public class LibaryBook{
		private String title;
		private String author;

		// constructor
	    public LibaryBook(String title, String author) {
	        this.title = title;
	        this.author = author;
	    }

	    // getter and setter for private attributes
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public void setAuthor(String author) {
	        this.author = author;
	    }
	}
}
