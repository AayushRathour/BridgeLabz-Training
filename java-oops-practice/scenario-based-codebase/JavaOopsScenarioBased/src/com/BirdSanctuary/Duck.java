package com.BirdSanctuary;

public class Duck extends Bird implements Flyable, Swimmable {

    Duck(String id, String name) {
        super(id, name, "Duck");
    }

    public void fly() {
        System.out.print(" | Can Fly");
    }

    public void swim() {
        System.out.println(" | Can Swim");
    }
}
