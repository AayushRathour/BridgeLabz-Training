package com.objectmodelling.level1.librarymanagementsystem;

public class LibarySystem {
	public static void main(String[] args) {
		// creating book and libary book object
		LibaryBook b1 = new LibaryBook("Let us C", "Author 1");
		LibaryBook b2 = new LibaryBook("Advance Java", "Author 2");
		Libary libary = new LibaryBook(b1, b2);
	}
}
