package com.Reflection;

import java.lang.reflect.Field;

class Person {
    private int age = 0;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<?> class1 = p.getClass();
        
        Field field = class1.getDeclaredField("age");
        field.setAccessible(true);
        field.setInt(p, 25);
        
        System.out.println(field.getInt(p));
    }
}