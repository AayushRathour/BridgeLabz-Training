package com.Reflection;

import java.lang.reflect.Field;

public class JSONRepresentation {
    static String toJson(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        
        StringBuilder sb = new StringBuilder("{");
        
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            
            sb.append(fields[i].getName());
            sb.append(":");
            sb.append(fields[i].get(obj));
            
            if (i < fields.length - 1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(toJson(p));
    }
}