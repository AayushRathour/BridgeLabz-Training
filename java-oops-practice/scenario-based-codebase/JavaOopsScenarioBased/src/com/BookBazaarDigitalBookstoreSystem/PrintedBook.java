package com.BookBazaarDigitalBookstoreSystem;

public class PrintedBook extends Book {
    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    public double applyDiscount(double amount) {
        return amount * 0.10;
    }
}