package com.aayush.fundoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

// Starts the Spring Boot application and scans all Fundoo components.
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class FundooUserServiceApplication {
    public static void main(String[] args) {
        // Launch the embedded server and create Spring-managed objects.
        SpringApplication.run(FundooUserServiceApplication.class, args);
    }
}
