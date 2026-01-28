package com.Reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformatinoReflection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();
        
        try {
            Class<?> class1 = Class.forName(className);
            
            Constructor<?>[] constructors = class1.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }
            
            Field[] fields = class1.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }
            
            Method[] methods = class1.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }
            
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}
