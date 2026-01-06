package com.PetPalVirtualPetCareApp;

public class Cat extends Pet implements Interactable {

    Cat(String name, int age) {
        super(name, "Cat", age);
    }

    public void makeSound() {
        System.out.println("Cat says: Meow");
    }
}
