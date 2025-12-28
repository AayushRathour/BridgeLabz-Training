package com.constructor.level1;

public class Ebook extends Book1{
	public static void main(String[] args) {
		// creating object and accessing the properties of super class
		Ebook book = new Ebook();
		book.setAuthor("Authro1");
		System.out.println(book.getAuthor());
		book.ISBN = "Book12";
		book.title = "Title of book";
	}
}