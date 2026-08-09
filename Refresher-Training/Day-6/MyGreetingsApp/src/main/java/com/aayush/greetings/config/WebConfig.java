package com.aayush.greetings.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Bean;

/**
 * Java-based Spring MVC configuration.
 * Equivalent of spring-mvc-config.xml + <mvc:annotation-driven/>.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.aayush.greetings.controller")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
