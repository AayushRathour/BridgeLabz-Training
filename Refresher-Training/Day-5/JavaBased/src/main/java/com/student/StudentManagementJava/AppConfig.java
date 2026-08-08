package com.student.StudentManagementJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java-based equivalent of applicationContext.xml.
 * Each @Bean method here is the same as a <bean> tag in the XML version.
 */
@Configuration
public class AppConfig {

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }

    @Bean
    public StudentService studentService() {
        // same as <constructor-arg ref="studentRepository"/>
        return new StudentService(studentRepository());
    }

}
