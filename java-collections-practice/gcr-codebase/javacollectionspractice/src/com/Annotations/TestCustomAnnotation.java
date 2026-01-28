package com.annotations;

import java.lang.reflect.Method;

public class TestCustomAnnotation {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();
        Method method = manager.getClass().getMethod("completeTask");

        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        System.out.println(taskInfo.priority());
        System.out.println(taskInfo.assignedTo());

        manager.completeTask();
    }
}