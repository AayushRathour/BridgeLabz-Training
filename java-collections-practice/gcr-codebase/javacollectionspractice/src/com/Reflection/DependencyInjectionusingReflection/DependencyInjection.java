package com.Reflection.DependencyInjectionusingReflection;

import java.lang.reflect.Field;

public class DependencyInjection {
    public static void injectDependencies(Object obj) throws Exception {
        Class<?> class1 = obj.getClass();

        for (Field field : class1.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = field.getType()
                        .getDeclaredConstructor()
                        .newInstance();
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.run();
    }
}