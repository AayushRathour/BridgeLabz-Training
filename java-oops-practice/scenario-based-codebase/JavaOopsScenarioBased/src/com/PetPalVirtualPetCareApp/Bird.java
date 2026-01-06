package com.PetPalVirtualPetCareApp;

public class Bird extends Pet implements Interactable {

    Bird(String name, int age) {
        super(name, "Bird", age);
    }

    public void makeSound() {
        System.out.println("Bird says: Chirp");
    }
}
