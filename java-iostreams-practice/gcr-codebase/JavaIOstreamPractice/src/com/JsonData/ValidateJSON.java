package com.jsondata;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        ObjectMapper m = new ObjectMapper();
        try {
            JsonNode student = m.readTree(new File("student.json"));

            if (!student.has("name") || !student.has("age") || !student.has("email")) {
                System.out.println("invalid");
                return;
            }

            if (!student.get("name").isTextual() || !student.get("age").isInt() || !student.get("email").isTextual()) {
                System.out.println("invalid");
                return;
            }

            System.out.println("valid");

        } 
        catch (Exception e) {
            System.out.println("invalid");
        }
    }
}
