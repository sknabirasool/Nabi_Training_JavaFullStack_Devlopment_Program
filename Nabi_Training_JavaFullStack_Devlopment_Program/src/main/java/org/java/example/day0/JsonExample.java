package org.java.example.day0;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"John\", \"age\":30}";

        try {
            Persons person = mapper.readValue(jsonString, Persons.class);
            System.out.println(person.name + " is " + person.age + " years old.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Persons {
    public String name;
    public int age;
}
