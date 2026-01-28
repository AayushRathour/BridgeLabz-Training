package com.annotations;

import java.lang.reflect.Method;

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskService.class.getMethod("processTask");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println(report.description());
        }
    }
}