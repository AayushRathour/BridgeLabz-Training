package com.SmartLibraryAutoSortBorrowedBooks;

import java.util.ArrayList;

public class MainClass {

    ArrayList<Book> borrowedBooks = new ArrayList<>();

    void addBook(String title) {
        borrowedBooks.add(new Book(title));

        for (int i = 1; i < borrowedBooks.size(); i++) {
            Book key = borrowedBooks.get(i);
            int j = i - 1;

            while (j >= 0 && borrowedBooks.get(j).title.compareToIgnoreCase(key.title) > 0) {
                borrowedBooks.set(j + 1, borrowedBooks.get(j));
                j--;
            }
            borrowedBooks.set(j + 1, key);
        }
    }

    void displayBooks() {
        for (Book b : borrowedBooks) {
            System.out.println(b.title);
        }
    }

    public static void main(String[] args) {
        MainClass lib = new MainClass();

        lib.addBook("Data Structures");
        lib.addBook("Algorithms");
        lib.addBook("Java Programming");
        lib.addBook("Artificial Intelligence");

        lib.displayBooks();
    }
}
