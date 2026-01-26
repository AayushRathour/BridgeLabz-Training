package com.JUnit.PerformanceTestingUsingTimeout;

public class TaskService {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}