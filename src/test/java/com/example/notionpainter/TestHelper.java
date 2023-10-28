package com.example.notionpainter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestHelper {
    public static void printObject(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            System.out.println(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
