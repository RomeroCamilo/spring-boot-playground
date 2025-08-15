package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.RandomGenerator;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    RandomGenerator randomGenerator;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        String randomUUID = randomGenerator.randomUUID();
        return "Hello World and I generated this random UUID: " + randomUUID;
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person) {
        // Connect to MongoDB (default local connection, no auth)
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("demo");
            MongoCollection<Document> collection = database.getCollection("people");

            // Convert Person to a Document
            Document doc = new Document()
                    .append("firstName", person.getFirstName())
                    .append("lastName", person.getLastName());

            // Insert into collection
            collection.insertOne(doc);

            return "Inserted person: " + person.getFirstName() + " " + person.getLastName();
        }
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        List<Person> peopleList = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("demo");
            MongoCollection<Document> collection = database.getCollection("people");

            FindIterable<Document> documents = collection.find();

            for (Document doc : documents) {
                String firstName = doc.getString("firstName");
                String lastName = doc.getString("lastName");
                peopleList.add(new Person(firstName, lastName));
            }
        }

        return peopleList;
    }

    // GET http://localhost:8080/proxy/greet?name=Ada
    @GetMapping("/greet")
    public Map<String, Object> proxyGreet(@RequestParam(defaultValue = "World") String name) {
        String url = "http://localhost:8084/greet?name=" + name;
        // Calls the other microservice and returns its JSON as-is
        return restTemplate.getForObject(url, Map.class);
    }


}
