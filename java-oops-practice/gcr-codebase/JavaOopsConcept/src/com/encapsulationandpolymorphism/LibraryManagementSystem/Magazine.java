package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class Magazine extends LibraryItem {
    private boolean available = true;

    // constructor
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}