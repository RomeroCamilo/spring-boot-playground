package com.example.demo.model;

public class Person {
    private String firstName;
    private String lastName;

    // No-args constructor
    public Person() {
    }

    // All-args constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // toString for debugging
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
