package com.Reflection;

import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting target = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxyObj, Method method, Object[] methodArgs) -> {
                    System.out.println("Calling method: " + method.getName());
                    return method.invoke(target, methodArgs);
                }
        );
        proxy.sayHello();
    }
}