package com.aayush.fundoo;

import com.aayush.fundoo.dto.LoginRequest;
import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.dto.ForgotPasswordRequest;
import com.aayush.fundoo.dto.ResetPasswordRequest;
import java.util.Map;
import java.util.UUID;
import java.io.ByteArrayInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = "app.exports.directory=target/test-exports")
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

        mockMvc.perform(get("/api/users/me")
                        .header("Authorization", "Bearer not-a-jwt"))
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

    @Test
    void jwtProtectsNoteReadsWritesAndOwnership() throws Exception {
        String aliceToken = registerAndLogin("alice.notes@fundoo.com");
        String bobToken = registerAndLogin("bob.notes@fundoo.com");
        String noteJson = objectMapper.writeValueAsString(Map.of(
                "title", "Alice private note",
                "content", "Only Alice may read this"));

        MvcResult createResult = mockMvc.perform(post("/api/notes")
                        .header("Authorization", "Bearer " + aliceToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(noteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Alice private note"))
                .andReturn();
        long noteId = objectMapper.readTree(createResult.getResponse().getContentAsString())
                .get("id").asLong();

        // GET and POST obtain identity through the same JWT filter.
        mockMvc.perform(get("/api/notes").header("Authorization", "Bearer " + aliceToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(noteId));
        mockMvc.perform(get("/api/notes/{id}", noteId)
                        .header("Authorization", "Bearer " + aliceToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(noteId));

        // Ownership is enforced in repository queries, not merely in the controller.
        mockMvc.perform(get("/api/notes/{id}", noteId)
                        .header("Authorization", "Bearer " + bobToken))
                .andExpect(status().isNotFound());
        mockMvc.perform(delete("/api/notes/{id}", noteId)
                        .header("Authorization", "Bearer " + bobToken))
                .andExpect(status().isNotFound());

        mockMvc.perform(delete("/api/notes/{id}", noteId)
                        .header("Authorization", "Bearer " + aliceToken))
                .andExpect(status().isNoContent());
    }

    @Test
    void noteOrganizationSearchFilterAndTagsWorkForTheOwner() throws Exception {
        String token = registerAndLogin("organize.notes@fundoo.com");
        String noteJson = objectMapper.writeValueAsString(Map.of(
                "title", "Sprint planning",
                "content", "Prepare the Spring Security sprint",
                "tags", java.util.List.of("work", "spring")));

        MvcResult createResult = mockMvc.perform(post("/api/notes")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(noteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tags.length()").value(2))
                .andReturn();
        long noteId = objectMapper.readTree(createResult.getResponse().getContentAsString())
                .get("id").asLong();

        mockMvc.perform(put("/api/notes/{id}/pin", noteId)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pinned").value(true));
        mockMvc.perform(put("/api/notes/{id}/archive", noteId)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.archived").value(true));
        mockMvc.perform(put("/api/notes/{id}/trash", noteId)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trashed").value(true));

        mockMvc.perform(get("/api/notes/search").param("keyword", "security")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(noteId));
        mockMvc.perform(get("/api/notes/filter")
                        .param("archived", "true")
                        .param("trashed", "true")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(noteId));
        mockMvc.perform(get("/api/notes/tags").header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
        mockMvc.perform(get("/api/notes/tags/{tagName}", "work")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(noteId));
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void authenticatedUserCanExportOnlyTheirNotesToExcel() throws Exception {
        String token = registerAndLogin("excel.export." + UUID.randomUUID() + "@fundoo.com");
        String noteJson = objectMapper.writeValueAsString(Map.of(
                "title", "Excel export note",
                "content", "This row must be written into the workbook",
                "tags", java.util.List.of("export")));

        mockMvc.perform(post("/api/notes")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(noteJson))
                .andExpect(status().isOk());

        MvcResult exportResult = mockMvc.perform(post("/api/notes/export/excel")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.exportedNotes").value(1))
                .andExpect(jsonPath("$.downloadUrl").exists())
                .andReturn();

        String downloadUrl = objectMapper.readTree(exportResult.getResponse().getContentAsString())
                .get("downloadUrl").asText();
        MvcResult downloadResult = mockMvc.perform(get(downloadUrl)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type",
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .andReturn();

        try (Workbook workbook = WorkbookFactory.create(
                new ByteArrayInputStream(downloadResult.getResponse().getContentAsByteArray()))) {
            org.junit.jupiter.api.Assertions.assertEquals("Excel export note",
                    workbook.getSheet("Notes").getRow(1).getCell(1).getStringCellValue());
            org.junit.jupiter.api.Assertions.assertEquals("export",
                    workbook.getSheet("Notes").getRow(1).getCell(3).getStringCellValue());
        }
    }

    private String registerAndLogin(String email) throws Exception {
        RegisterRequest register = new RegisterRequest();
        register.setFirstname("Test");
        register.setLastname("User");
        register.setEmail(email);
        register.setPassword("secret123");
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        LoginRequest login = new LoginRequest();
        login.setEmail(email);
        login.setPassword("secret123");
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andReturn();
        return objectMapper.readTree(result.getResponse().getContentAsString()).get("token").asText();
    }
}
