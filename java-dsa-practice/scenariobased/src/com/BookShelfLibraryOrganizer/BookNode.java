package com.BookShelfLibraryOrganizer;

public class BookNode {
	int id;
	String title;
	boolean isAvailable;
	BookNode next;
	
	public BookNode(int id, String title) {
		this.id = id;
		this.title = title;
		this.isAvailable = true;
	}
}