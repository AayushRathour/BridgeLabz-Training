package com.PetPalVirtualPetCareApp;

public class MainClass{
    public static void main(String[] args) {

        Pet pet1 = new Dog("Buddy", 3);
        Pet pet2 = new Cat("Kitty", 2);

        pet1.feed();
        pet1.makeSound();

        pet2.play();
        pet2.makeSound();
    }
}
