package com.JUnit.PerformanceTestingUsingTimeout;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TaskServiceTest {
    @Test
    @Timeout(2)
    void testLongRunningTaskTimeout() throws InterruptedException {
        TaskService service = new TaskService();
        service.longRunningTask();
    }
}