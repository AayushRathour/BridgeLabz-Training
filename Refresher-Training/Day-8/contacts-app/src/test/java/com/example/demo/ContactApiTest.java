package com.example.demo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ContactApiTest {
	
	// Test to verify that all contacts can be retrieved successfully
    @Test
    void getAllContact() {

        given()
            .when()
            .get("http://localhost:8080/contacts")
            .then()
            .statusCode(200);
    }

    // Test to verify that a new contact can be created successfully
    @Test
    void createContact() {

        String contact = """
            {
                "firstName": "Aayush",
                "lastName": "Rathour",
                "phone": "9999999999",
                "alternativePhone": "8888888888",
                "email": "aayush@gmail.com"
            }
            """;

        given()
            .contentType("application/json")
            .body(contact)
            .when()
            .post("http://localhost:8080/contacts")
            .then()
            .statusCode(200)
            .body("firstName", equalTo("Aayush"));
    }
}