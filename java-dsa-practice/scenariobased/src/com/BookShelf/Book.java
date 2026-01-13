package com.BookShelf;

public class Book {
	int id;
	String title;
	boolean isAvailable;
	Book next;
	
	public Book(int id, String title) {
		this.id = id;
		this.title = title;
		this.isAvailable = true;
	}
}