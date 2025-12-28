package com.constructor.level1;

public class Person {
    private String name;
    private int age;

    public Person(Person person) {
        if (person != null) {
            this.name = person.name;
            this.age = person.age;
        }
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Name1", 20);
        Person p2 = new Person(p1);

        System.out.println(p2.name);
        System.out.println(p2.age);
    }
}
