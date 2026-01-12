package com.BrowserBuddyTabHistoryManager;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HistoryManager manager = new HistoryManager();

        while (true) {
        	System.out.println();
            System.out.println("1. Open New Tab");
            System.out.println("2. Open Link");
            System.out.println("3. Move Forward");
            System.out.println("4. Move Back");
            System.out.println("5. Show History");
            System.out.println("6. Switch Tab");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                manager.openNewTab();
                System.out.println("New tab opened.");
            }
            
            else if (choice == 2) {
                System.out.print("Enter URL: ");
                String url = sc.nextLine();
                manager.openaLink(url);
            }
            
            else if (choice == 3) manager.moveForward();

            else if (choice == 4) manager.moveBack();

            else if (choice == 5) manager.showHistory();

            else if (choice == 6) {
                System.out.print("Enter tab number: ");
                int idx = sc.nextInt();
                manager.open(idx);
            } 
            
            else if (choice == 7) return;
            
            else System.out.println("Enter a valid choice choice!");
        }
    }
}