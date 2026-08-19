package com.aayush.fundoo;

import com.aayush.fundoo.dto.LoginRequest;
import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.dto.ForgotPasswordRequest;
import com.aayush.fundoo.dto.ResetPasswordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthFlowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerThenLogin_returnsJwtThatUnlocksProtectedEndpoint() throws Exception {
        RegisterRequest register = new RegisterRequest();
        register.setFirstname("Aayush");
        register.setLastname("Rathour");
        register.setEmail("aayush.flowtest@fundoo.com");
        register.setPassword("secret123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        LoginRequest login = new LoginRequest();
        login.setEmail("aayush.flowtest@fundoo.com");
        login.setPassword("secret123");

        MvcResult loginResult = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andReturn();

        String responseBody = loginResult.getResponse().getContentAsString();
        String token = objectMapper.readTree(responseBody).get("token").asText();

        // Protected endpoint fails without a token
        mockMvc.perform(get("/api/users/me"))
                .andExpect(status().isUnauthorized());

        // ...and succeeds with the JWT from login
        mockMvc.perform(get("/api/users/me")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("aayush.flowtest@fundoo.com"));
    }

    @Test
    void registerDuplicateEmail_returns409() throws Exception {
        RegisterRequest register = new RegisterRequest();
        register.setFirstname("Dup");
        register.setLastname("User");
        register.setEmail("dup@fundoo.com");
        register.setPassword("secret123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isConflict());
    }

    @Test
    void loginWrongPassword_returns401() throws Exception {
        RegisterRequest register = new RegisterRequest();
        register.setFirstname("Wrong");
        register.setLastname("Pass");
        register.setEmail("wrongpass@fundoo.com");
        register.setPassword("correctPassword");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        LoginRequest login = new LoginRequest();
        login.setEmail("wrongpass@fundoo.com");
        login.setPassword("wrongPassword");

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void forgotPasswordThenReset_allowsLoginWithNewPassword() throws Exception {
        RegisterRequest register = new RegisterRequest();
        register.setFirstname("Reset");
        register.setLastname("User");
        register.setEmail("reset.flowtest@fundoo.com");
        register.setPassword("secret123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        ForgotPasswordRequest forgot = new ForgotPasswordRequest();
        forgot.setEmail("reset.flowtest@fundoo.com");
        MvcResult forgotResult = mockMvc.perform(post("/api/auth/forgot-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(forgot)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resetToken").exists())
                .andReturn();

        ResetPasswordRequest reset = new ResetPasswordRequest();
        reset.setToken(objectMapper.readTree(forgotResult.getResponse().getContentAsString()).get("resetToken").asText());
        reset.setNewPassword("newSecret123");
        mockMvc.perform(post("/api/auth/reset-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reset)))
                .andExpect(status().isOk());

        LoginRequest login = new LoginRequest();
        login.setEmail("reset.flowtest@fundoo.com");
        login.setPassword("newSecret123");
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }
}
