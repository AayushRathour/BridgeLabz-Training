package com.annotations;

import java.lang.reflect.Method;

public class ProjectService {
    @Todo(task = "Task 1", assignedTo = "Dev 1", priority = "HIGH")
    public void task1() {}

    @Todo(task = "Task 2", assignedTo = "Dev 2")
    public void task2() {}

    @Todo(task = "Task 3", assignedTo = "DB 1", priority = "LOW")
    public void task3() {}
    
    public static void main(String[] args) {
    	Method[] methods = ProjectService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                
                System.out.println(method.getName());
                System.out.println(todo.task() + " " +todo.assignedTo() + " " + todo.priority());
                System.out.println();
            }
        }
	}
}