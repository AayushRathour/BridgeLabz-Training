package com.aayush.reminderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Fundoo Reminder Service.
 *
 * Responsibilities:
 *   1. REST endpoints to set / clear a reminder on a note.
 *   2. Scheduled job that fires every N seconds (configured in application.yml),
 *      finds all notes whose reminderAt <= now and reminderSent = false,
 *      and marks them as reminderSent = true.
 *
 * Authentication: same JWT token issued by auth-service (userId as subject).
 * Service discovery: registers with Eureka so API-Gateway can load-balance.
 */
@SpringBootApplication
@EnableScheduling
public class FundooReminderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundooReminderServiceApplication.class, args);
    }
}
