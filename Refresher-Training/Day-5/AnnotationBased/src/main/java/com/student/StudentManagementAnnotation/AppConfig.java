package com.student.StudentManagementAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Pure annotation-based config: no @Bean methods here at all.
 * Spring scans this package (and sub-packages), finds classes marked
 * @Repository / @Service / @Component, and wires them up automatically
 * based on their @Autowired constructors.
 */
@Configuration
@ComponentScan(basePackages = "com.student.StudentManagementAnnotation")
public class AppConfig {

}
