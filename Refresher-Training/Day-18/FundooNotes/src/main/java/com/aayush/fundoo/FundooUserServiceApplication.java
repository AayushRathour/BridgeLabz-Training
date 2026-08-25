package com.aayush.fundoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

// Starts the Spring Boot application and scans all Fundoo components.
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
// Turns on @JmsListener processing (Reminder & Notification module)
@EnableJms
// Turns on @Scheduled processing (the reminder-due polling job)
@EnableScheduling
public class FundooUserServiceApplication {
    public static void main(String[] args) {
        // Launch the embedded server and create Spring-managed objects.
        SpringApplication.run(FundooUserServiceApplication.class, args);
    }
}
