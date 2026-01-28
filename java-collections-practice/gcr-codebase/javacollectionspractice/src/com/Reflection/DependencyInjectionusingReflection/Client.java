package com.Reflection.DependencyInjectionusingReflection;

public class Client {
    @Inject
    private Service service;

    public void run() {
        service.process();
    }
}