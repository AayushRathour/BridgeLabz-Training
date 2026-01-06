package com.PetPalVirtualPetCareApp;

public class Dog extends Pet implements Interactable {

    Dog(String name, int age) {
        super(name, "Dog", age);
    }

    public void makeSound() {
        System.out.println("Dog says: Bark");
    }
}
