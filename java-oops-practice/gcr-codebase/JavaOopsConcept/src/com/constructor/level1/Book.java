package com.constructor.level1;

public class Book {
    String title;
    String author;
    double price; 
    
    Book() {
        title = "";
        author = "";
        price = 0.0;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {
   

        Book book2 = new Book("Java Basics", "James Gosling", 499.50);
        System.out.println(book2.title);
        System.out.println(book2.author);
        System.out.println(book2.price);
    }
}
