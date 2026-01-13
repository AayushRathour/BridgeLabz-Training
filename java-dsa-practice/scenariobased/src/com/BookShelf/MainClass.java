package com.BookShelf;

import java.util.Scanner;

public class MainClass{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library system = new Library();

        while (true) {
            System.out.println("1. Insert book");
            System.out.println("2. Delete book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter id:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter title:");
                String title = sc.nextLine();

                System.out.println("Enter genre:");
                String genre = sc.nextLine();

                system.insertBook(id, title, genre);
            }

            else if (choice == 2) {
                System.out.println("Enter id:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter genre:");
                String genre = sc.nextLine();

                system.deleteBook(genre, id);
            }

            else if (choice == 3) {
                System.out.println("Enter id:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter genre:");
                String genre = sc.nextLine();

                system.borrowBook(genre, id);
            }

            else if (choice == 4) {
                System.out.println("Enter id:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter genre:");
                String genre = sc.nextLine();

                system.returnBook(genre, id);
            }

            else if (choice == 5) break;

            else System.out.println("Enter a valid input");
        }

        sc.close();
    }
}