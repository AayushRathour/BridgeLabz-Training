package com.BirdSanctuary;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Sanctuary s = new Sanctuary();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to EcoWing Bird Sanctuary");
            System.out.println("1. Add Bird");
            System.out.println("2. Display All Birds");
            System.out.println("3. Display All Flying Birds");
            System.out.println("4. Display All Swimming Birds");
            System.out.println("5. Display Both Flying & Swimming Birds");
            System.out.println("6. Delete Bird by ID");
            System.out.println("7. Sanctuary Report");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                String id = sc.next();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Type (Eagle/Duck/Penguin/Kiwi): ");
                String type = sc.next();

                if (type.equalsIgnoreCase("Eagle"))
                    s.addBird(new Eagle(id, name));
                else if (type.equalsIgnoreCase("Duck"))
                    s.addBird(new Duck(id, name));
                else if (type.equalsIgnoreCase("Penguin"))
                    s.addBird(new Penguin(id, name));
                else if (type.equalsIgnoreCase("Kiwi"))
                    s.addBird(new Kiwi(id, name));
            }

            else if (choice == 2) s.displayAll();
            else if (choice == 3) s.displayFlying();
            else if (choice == 4) s.displaySwimming();
            else if (choice == 5) s.displayBoth();
            else if (choice == 6) {
                System.out.print("Enter ID: ");
                s.removeById(sc.next());
            }
            else if (choice == 7) s.report();
            else break;
        }
    }
}
