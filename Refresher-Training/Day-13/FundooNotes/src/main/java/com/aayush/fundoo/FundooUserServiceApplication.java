package com.aayush.fundoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

// Authentication is handled exclusively by JWTs in SecurityConfig.
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class FundooUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundooUserServiceApplication.class, args);
    }
}
