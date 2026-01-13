package com.BookShelf;

import java.util.HashMap;
import java.util.HashSet;

public class Library{
	HashMap<String, Book> mp = new HashMap<>();
	HashSet<Integer> set = new HashSet<>();
	
	public void insertBook(int id, String title, String genre) {
		if(set.contains(id)) {
			System.out.println("Book with id " + id + " already exist");
			return;
		}
		
		Book bookNode = new Book(id, title);
		set.add(id);
		
		if(!mp.containsKey(genre)) {
			mp.put(genre, bookNode);
			return;
		}
		
		Booktemp = mp.get(genre);
		while(temp.next != null) temp = temp.next;
		temp.next = bookNode;
	}
	
	public void deleteBook(String genre, int id) {
		if(!mp.containsKey(genre)) {
			System.out.println("No book exist in genre " + genre);
			return;
		}
		
		Book temp = mp.get(genre);
		if(temp.id == id) {
			System.out.println("Book deleted successfully");
			mp.remove(genre);
			return;
		}
		
		while(temp.next != null && temp.next.id != id) temp = temp.next;
		
		if(temp.next == null) {
			System.out.println("Book does not exist");
			return;
		}
		
		temp.next = temp.next.next;
		System.out.println("Book deleted successfully");
	}
	
	public void borrowBook(String genre, int id) {
		if(!mp.containsKey(genre)) {
			System.out.println("No book exist in genre " + genre);
			return;
		}
		
		BookNode temp = mp.get(genre);
		while(temp != null && temp.id != id) temp = temp.next;
		
		if(temp == null) {
			System.out.println("Book with id " + id + " does not exist in genre " + genre);
			return;
		}
		if(!temp.isAvailable) {
			System.out.println("The book is not available");
			return;
		}
		temp.isAvailable = false;
		System.out.println("Book borrowed successfully");
	}
	
	public void returnBook(String genre, int id) {
		if(!mp.containsKey(genre)) {
			System.out.println("No book exist in genre " + genre);
			return;
		}
		
		Book temp = mp.get(genre);
		while(temp != null && temp.id != id) temp = temp.next;
		
		if(temp == null) {
			System.out.println("Book with id " + id + " does not exist in genre " + genre);
			return;
		}
		
		temp.isAvailable = true;
		System.out.println("Book returned successfully");
	}
}