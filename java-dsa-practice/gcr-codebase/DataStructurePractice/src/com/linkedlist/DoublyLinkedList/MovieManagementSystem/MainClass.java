package com.linkedlist.DoublyLinkedList.MovieManagementSystem;

public class MainClass {
    public static void main(String[] args) {

        MovieList ml = new MovieList();

        ml.addFirst("Inception", "Nolan", 2010, 8.8);
        ml.addLast("Interstellar", "Nolan", 2014, 8.6);
        ml.addAtPos(2, "Tenet", "Nolan", 2020, 7.5);

        ml.displayForward();

        ml.updateRating("Tenet", 8.0);
        ml.search("Nolan", 8.6);

        ml.removeByTitle("Inception");

        ml.displayReverse();
    }
}
