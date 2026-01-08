package com.BookBazaarDigitalBookstoreSystem;

public class Order {
    private Book[] books;
    private int[] quantity;
    private int count;
    private double total;
    private boolean completed;

    public Order() {
        books = new Book[5];
        quantity = new int[5];
        count = 0;
        total = 0;
        completed = false;
    }

    public void addBook(Book book, int qty) {
        if(book.reduceStock(qty)) {
            books[count] = book;
            quantity[count] = qty;
            double amount = book.getPrice() * qty;
            total += amount - book.applyDiscount(amount);
            count++;
        }
    }

    public double getTotal() {
        return total;
    }

    protected void setCompleted(boolean status) {
        completed = status;
    }

    public boolean isCompleted() {
        return completed;
    }
}