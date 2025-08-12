package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // No-args constructor
@AllArgsConstructor // All-args constructor
public class Person {
    private String firstName;
    private String lastName;
}
