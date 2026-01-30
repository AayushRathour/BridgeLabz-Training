package com.jsondata;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;

public class ValidateEmail {
    public static void main(String[] args) {
        String schemaStr = """
        {
          "type": "object",
          "properties": {
            "email": {
              "type": "string",
              "format": "email"
            }
          },
          "required": ["email"]
        }
        """;

        String jsonStr = """
        {
          "email": "samplemail@example.com"
        }
        """;

        JSONObject schemaJson = new JSONObject(schemaStr);
        JSONObject jsonData = new JSONObject(jsonStr);

        Schema schema = SchemaLoader.load(schemaJson);

        try {
            schema.validate(jsonData);
            System.out.println("Email is valid");
        }
        catch (ValidationException e) {
            System.out.println("Invalid email");
            System.out.println(e.getMessage());
        }
    }
}
