package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class Book extends LibraryItem {
    private boolean available = true;

    // constructor
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 5;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}