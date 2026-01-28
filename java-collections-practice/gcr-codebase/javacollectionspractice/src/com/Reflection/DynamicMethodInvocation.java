package com.Reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String methodName = sc.next();
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        MathOperations obj = new MathOperations();
        
        Method method = obj.getClass().getMethod(methodName, int.class, int.class);
        
        Object result = method.invoke(obj, a, b);
        System.out.println(result);
    }
}