package com.annotations;

import java.lang.reflect.Method;

public class Service {
	@ImportantMethod
    public void task1() {
        System.out.println("task 1");
    }

    @ImportantMethod(level = "MEDIUM")
    public void task2() {
        System.out.println("task 2");
    }

    public void task3() {
        System.out.println("task 3");
    }
    
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " : " + im.level());
            }
        }
    }
}
