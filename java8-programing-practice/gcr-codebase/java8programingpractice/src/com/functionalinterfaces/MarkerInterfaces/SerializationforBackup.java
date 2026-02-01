package com.functionalinterfaces.MarkerInterfaces;

import java.io.Serializable;

class UserData implements Serializable {

    String name;
    int age;

    UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationforBackup {
    public static void main(String[] args) {

        UserData u = new UserData("Aayush", 21);

        if(u instanceof Serializable)
            System.out.println("Object eligible for backup");
        else
            System.out.println("Backup not allowed");
    }
}
