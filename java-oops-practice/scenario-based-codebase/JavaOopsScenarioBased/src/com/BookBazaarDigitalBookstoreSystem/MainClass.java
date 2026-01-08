package com.BookBazaarDigitalBookstoreSystem;

public class MainClass {
    public static void main(String[] args) {
        Book b1 = new EBook("Java", "Author 1", 500, 10);
        Book b2 = new PrintedBook("DSA", "Author 2", 600, 5);

        Order order = new Order();

        order.addBook(b1, 2);
        order.addBook(b2, 1);

        System.out.println("Total Amount : " + order.getTotal());
    }
}