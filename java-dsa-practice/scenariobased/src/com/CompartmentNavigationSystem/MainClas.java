package com.CompartmentNavigationSystem;

public class MainClas {
    public static void main(String[] args) {

        Compartments ir = new Compartments();

        ir.insertAt(10);
        ir.insertAt(20);
        ir.insertAt(30);

        System.out.println("All Compartments:");
        ir.display();

        System.out.println("\nMove Forward:");
        ir.moveForward();

        System.out.println("Move Backward:");
        ir.moveBackward();

        System.out.println("Remove 20:");
        ir.remove(20);
        ir.display();
    }
}
