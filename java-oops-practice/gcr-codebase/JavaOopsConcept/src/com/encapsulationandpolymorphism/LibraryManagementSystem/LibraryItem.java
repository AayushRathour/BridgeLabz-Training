package com.encapsulationandpolymorphism.LibraryManagementSystem;

public abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;
    private String borrowerData;

    // constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrowerData = "Protected";
    }

    // abstract method
    public abstract int getLoanDuration();

    // concrete method
    public void getItemDetails() {
        System.out.println(itemId + " | " + title + " | " + author);
    }

    public String getBorrowerData() {
        return "Access Restricted";
    }
}