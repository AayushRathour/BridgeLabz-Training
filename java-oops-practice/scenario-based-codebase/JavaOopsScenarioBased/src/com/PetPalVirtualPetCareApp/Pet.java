package com.PetPalVirtualPetCareApp;

public class Pet {
    String name;
    String type;
    int age;

    private int hunger;
    private int energy;

    Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        hunger = 5;
        energy = 5;
    }

    public void feed() {        // must be public
        hunger = hunger - 2;
    }

    public void play() {        // must be public
        energy = energy - 2;
        hunger = hunger + 1;
    }

    public void sleep() {       // must be public
        energy = energy + 3;
    }

    public void makeSound() {
        System.out.println("Pet sound");
    }
}
