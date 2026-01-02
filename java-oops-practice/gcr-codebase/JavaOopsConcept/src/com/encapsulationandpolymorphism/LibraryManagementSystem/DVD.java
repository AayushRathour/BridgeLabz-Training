package com.encapsulationandpolymorphism.LibraryManagementSystem;

public class DVD extends LibraryItem {
    private boolean available = true;

    // constructor
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 1;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}