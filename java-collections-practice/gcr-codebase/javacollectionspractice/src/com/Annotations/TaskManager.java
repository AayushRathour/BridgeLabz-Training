package com.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    int priority();
    String assignedTo();
}

public class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "User 1")
    public void completeTask() {
        System.out.println("Task completed");
    }
}
