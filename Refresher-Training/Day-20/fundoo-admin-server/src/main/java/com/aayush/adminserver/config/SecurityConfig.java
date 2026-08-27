package com.aayush.adminserver.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Secures the Spring Boot Admin UI.
 * - Login page at /login
 * - Logout at /logout
 * - All /actuator/health endpoints are public (needed for health checks)
 * - Everything else requires authentication
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AdminServerProperties adminServer;

    public SecurityConfig(AdminServerProperties adminServer) {
        this.adminServer = adminServer;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminServer.path("/"));

        http
            .authorizeHttpRequests(auth -> auth
                // Allow actuator health for liveness/readiness checks
                .requestMatchers(adminServer.path("/actuator/health")).permitAll()
                .requestMatchers(adminServer.path("/actuator/info")).permitAll()
                // Permit static assets and login page
                .requestMatchers(adminServer.path("/assets/**")).permitAll()
                .requestMatchers(adminServer.path("/login")).permitAll()
                // All other requests require login
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage(adminServer.path("/login"))
                .successHandler(successHandler)
            )
            .logout(logout -> logout
                .logoutUrl(adminServer.path("/logout"))
                .logoutSuccessUrl(adminServer.path("/login"))
            )
            // CSRF must be disabled for Admin Server actuator endpoints
            // (clients POST to /instances etc.) but enabled for browser requests
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringRequestMatchers(
                    new AntPathRequestMatcher(adminServer.path("/instances")),
                    new AntPathRequestMatcher(adminServer.path("/instances/*")),
                    new AntPathRequestMatcher(adminServer.path("/actuator/**"))
                )
            );

        return http.build();
    }
}
