package com.BirdSanctuary;

import java.util.*;

public class Sanctuary {
    private ArrayList<Bird> birds = new ArrayList<>();

    public void addBird(Bird b) {
        birds.add(b);
    }

    public void displayAll() {
        for (Bird b : birds) {
            b.display();
            if (b instanceof Flyable) ((Flyable) b).fly();
            if (b instanceof Swimmable) ((Swimmable) b).swim();
            if (!(b instanceof Flyable) && !(b instanceof Swimmable))
                System.out.println(" | Cannot Fly or Swim");
        }
    }

    public void displayFlying() {
        for (Bird b : birds)
            if (b instanceof Flyable) b.display();
    }

    public void displaySwimming() {
        for (Bird b : birds)
            if (b instanceof Swimmable) b.display();
    }

    public void displayBoth() {
        for (Bird b : birds)
            if (b instanceof Flyable && b instanceof Swimmable)
                b.display();
    }

    public void removeById(String id) {
        birds.removeIf(b -> b.getId().equals(id));
    }

    public void report() {
        int fly = 0, swim = 0, both = 0, neither = 0;

        for (Bird b : birds) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else neither++;
        }

        System.out.println("Flyable: " + fly);
        System.out.println("Swimmable: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + neither);
    }
}
