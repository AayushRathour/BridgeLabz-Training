package com.aayush.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Boot Admin Server — monitors all registered microservices.
 *
 * Eureka auto-discovery: all services that register with Eureka and expose
 * /actuator endpoints are automatically shown in the Admin UI at :9090.
 *
 * Default credentials (dev): admin / admin  (see application.yml)
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class FundooAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundooAdminServerApplication.class, args);
    }
}
