package com.BookBazaarDigitalBookstoreSystem;

public class EBook extends Book {
    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    public double applyDiscount(double amount) {
        return amount * 0.20;
    }
}