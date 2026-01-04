package com.linkedlist.DoublyLinkedList.MovieManagementSystem;

//Doubly linked list node for movie
public class MovieNode {
 String title, director;
 int year;
 double rating;
 MovieNode next, prev;

 MovieNode(String title, String director, int year, double rating) {
     this.title = title;
     this.director = director;
     this.year = year;
     this.rating = rating;
     this.next = null;
     this.prev = null;
 }
}
