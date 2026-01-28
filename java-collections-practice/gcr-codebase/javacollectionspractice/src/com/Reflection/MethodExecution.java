package com.Reflection;

import java.lang.reflect.Method;

public class MethodExecution {
    static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Class<?> class1 = obj.getClass();
        Method method = class1.getDeclaredMethod(methodName);
        method.setAccessible(true);

        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        measureExecutionTime(task, "method");
    }
}