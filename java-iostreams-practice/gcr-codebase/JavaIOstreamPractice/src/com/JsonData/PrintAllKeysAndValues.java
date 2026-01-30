package com.JsonData;

import java.io.File;
import com.fasterxml.jackson.databind.*;

public class PrintAllKeysAndValues
{
    public static void main(String[] args)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode node = mapper.readTree(new File("data.json"));

            node.fields().forEachRemaining(e ->
            {
                System.out.println(e.getKey() + " : " + e.getValue());
            });
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
