package com.annotations;

import java.lang.reflect.Method;

public class PerformanceService {
    @LogExecutionTime
    public void method1() throws InterruptedException {
        Thread.sleep(100);
    }

    @LogExecutionTime
    public void method2() throws InterruptedException {
        Thread.sleep(300);
    }
    
    public static void main(String[] args) throws Exception {
        PerformanceService service = new PerformanceService();
        Method[] methods = PerformanceService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
            	method.setAccessible(true);
            	
                long start = System.nanoTime();
                method.invoke(service);
                long end = System.nanoTime();
                
                System.out.println(method.getName() + " " + (end - start));
            }
        }
    }
}