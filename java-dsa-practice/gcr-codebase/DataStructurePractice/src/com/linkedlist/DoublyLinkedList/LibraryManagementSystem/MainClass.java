package com.linkedlist.DoublyLinkedList.LibraryManagementSystem;

public class MainClass {
	
	    public static void main(String[] args) {

	        LibraryList lib = new LibraryList();

	        lib.addFirst(101, "Java Basics", "Aay", "Programming", true);
	        lib.addLast(102, "DSA", "Rathour", "Computer Science", true);
	        lib.addAtPos(2, 103, "AI Intro", "Tech", "AI", false);

	        lib.displayForward();

	        lib.updateStatus(103, true);
	        lib.search("DSA", "");

	        lib.removeById(101);

	        lib.displayReverse();
	        lib.countBooks();
	    }
	}

