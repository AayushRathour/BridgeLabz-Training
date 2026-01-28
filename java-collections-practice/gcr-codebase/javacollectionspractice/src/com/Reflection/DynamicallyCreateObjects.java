package com.Reflection;

import java.lang.reflect.Constructor;

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> class1 = Class.forName("com.reflection.Student");
        
        Constructor<?> constructor = class1.getDeclaredConstructor();
        
        Object obj = constructor.newInstance();
        System.out.println(obj);
    }
}