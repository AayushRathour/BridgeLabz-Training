package com.aayush.fundoo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.aayush.fundoo.security.JwtAuthenticationFilter;
import com.aayush.fundoo.security.JwtService;

class JwtAuthenticationFilterTest {

    private JwtService jwtService;
    private JwtAuthenticationFilter filter;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
        ReflectionTestUtils.setField(jwtService, "secret", "ChangeThisFundooNotesSecretKeyBeforeProdUse1234567890");
        ReflectionTestUtils.setField(jwtService, "expiration", 60_000L);
        // The filter intentionally has no Redis dependency. This is the
        // Day 13-15 regression test for a Redis-unavailable environment.
        filter = new JwtAuthenticationFilter(jwtService);
    }

    @AfterEach
    void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void validBearerTokenAuthenticatesRequestWithoutRedis() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/api/notes");
        request.addHeader("Authorization", "Bearer " + jwtService.generateToken("reader@fundoo.com"));

        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertThat(authentication).isNotNull();
        assertThat(authentication.isAuthenticated()).isTrue();
        assertThat(authentication.getName()).isEqualTo("reader@fundoo.com");
    }

    @Test
    void invalidOrExpiredTokenDoesNotAuthenticateRequest() throws Exception {
        MockHttpServletRequest invalidRequest = new MockHttpServletRequest("GET", "/api/users/me");
        invalidRequest.addHeader("Authorization", "Bearer not-a-jwt");
        filter.doFilter(invalidRequest, new MockHttpServletResponse(), new MockFilterChain());
        assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();

        JwtService expiredJwtService = new JwtService();
        ReflectionTestUtils.setField(expiredJwtService, "secret", "ChangeThisFundooNotesSecretKeyBeforeProdUse1234567890");
        ReflectionTestUtils.setField(expiredJwtService, "expiration", -1_000L);
        MockHttpServletRequest expiredRequest = new MockHttpServletRequest("GET", "/api/notes/1");
        expiredRequest.addHeader("Authorization", "Bearer " + expiredJwtService.generateToken("reader@fundoo.com"));
        filter.doFilter(expiredRequest, new MockHttpServletResponse(), new MockFilterChain());
        assertThat(SecurityContextHolder.getContext().getAuthentication()).isNull();
    }
}
