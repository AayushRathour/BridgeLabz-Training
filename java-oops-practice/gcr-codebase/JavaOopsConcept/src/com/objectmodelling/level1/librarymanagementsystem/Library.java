package com.objectmodelling.level1.librarymanagementsystem;

import java.util.ArrayList;

public class Library {
	// storing list of books
	public ArrayList<LibaryBook> books;
	
	// using varargs to take add in list
	public Library(LibaryBook... curr) {
		books = new ArrayList<LibaryBook>();
		for(LibaryBook book : curr) books.add(book);
	}
}