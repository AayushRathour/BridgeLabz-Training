package com.BirdSanctuary;

public class Eagle extends Bird implements Flyable {

    Eagle(String id, String name) {
        super(id, name, "Eagle");
    }

    public void fly() {
        System.out.println(" | Can Fly");
    }
}
