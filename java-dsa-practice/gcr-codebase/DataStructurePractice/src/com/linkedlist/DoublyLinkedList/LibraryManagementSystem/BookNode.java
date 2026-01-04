package com.linkedlist.DoublyLinkedList.LibraryManagementSystem;


public class BookNode {
 int id;
 String title, author, genre;
 boolean available;
 BookNode next, prev;

 BookNode(int id, String title, String author, String genre, boolean available) {
     this.id = id;
     this.title = title;
     this.author = author;
     this.genre = genre;
     this.available = available;
     this.next = null;
     this.prev = null;
 }
}
