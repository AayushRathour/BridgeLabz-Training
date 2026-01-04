package com.linkedlist.DoublyLinkedList.LibraryManagementSystem;

public class LibraryList {
	

	    BookNode head, tail;

	    // add book at beginning
	    void addFirst(int id, String t, String a, String g, boolean av) {
	        BookNode b = new BookNode(id, t, a, g, av);
	        if (head == null) {
	            head = tail = b;
	            return;
	        }
	        b.next = head;
	        head.prev = b;
	        head = b;
	    }

	    // add book at end
	    void addLast(int id, String t, String a, String g, boolean av) {
	        BookNode b = new BookNode(id, t, a, g, av);
	        if (head == null) {
	            head = tail = b;
	            return;
	        }
	        tail.next = b;
	        b.prev = tail;
	        tail = b;
	    }

	    // add book at specific position
	    void addAtPos(int pos, int id, String t, String a, String g, boolean av) {
	        if (pos == 1) {
	            addFirst(id, t, a, g, av);
	            return;
	        }

	        BookNode temp = head;
	        for (int i = 1; i < pos - 1 && temp != null; i++)
	            temp = temp.next;

	        if (temp == null || temp.next == null) {
	            addLast(id, t, a, g, av);
	            return;
	        }

	        BookNode b = new BookNode(id, t, a, g, av);
	        b.next = temp.next;
	        b.prev = temp;
	        temp.next.prev = b;
	        temp.next = b;
	    }

	    // remove book by ID
	    void removeById(int id) {
	        BookNode t = head;
	        while (t != null) {
	            if (t.id == id) {

	                if (t == head) head = t.next;
	                if (t == tail) tail = t.prev;

	                if (t.prev != null) t.prev.next = t.next;
	                if (t.next != null) t.next.prev = t.prev;

	                return;
	            }
	            t = t.next;
	        }
	    }

	    // search by title or author
	    void search(String title, String author) {
	        BookNode t = head;
	        while (t != null) {
	            if (t.title.equalsIgnoreCase(title) ||
	                t.author.equalsIgnoreCase(author)) {

	                System.out.println(t.id + " | " + t.title + " | " +
	                                   t.author + " | " + t.genre + " | " +
	                                   (t.available ? "Available" : "Not Available"));
	            }
	            t = t.next;
	        }
	    }

	    // update availability using book ID
	    void updateStatus(int id, boolean av) {
	        BookNode t = head;
	        while (t != null) {
	            if (t.id == id) {
	                t.available = av;
	                return;
	            }
	            t = t.next;
	        }
	    }

	    // display forward
	    void displayForward() {
	        BookNode t = head;
	        while (t != null) {
	            System.out.println(t.id + " | " + t.title + " | " +
	                               t.author + " | " + t.genre + " | " +
	                               (t.available ? "Available" : "Not Available"));
	            t = t.next;
	        }
	    }

	    // display reverse
	    void displayReverse() {
	        BookNode t = tail;
	        while (t != null) {
	            System.out.println(t.id + " | " + t.title + " | " +
	                               t.author + " | " + t.genre + " | " +
	                               (t.available ? "Available" : "Not Available"));
	            t = t.prev;
	        }
	    }

	    // count total books
	    void countBooks() {
	        int c = 0;
	        BookNode t = head;
	        while (t != null) {
	            c++;
	            t = t.next;
	        }
	        System.out.println("Total Books : " + c);
	    }
	}

