package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.RandomGenerator;

@RestController
public class TestController {

    @Autowired
    RandomGenerator randomGenerator;

    @GetMapping("/hello")
    public String sayHello() {
        String randomUUID = randomGenerator.randomUUID();
        return "Hello World and I generated this random UUID: " + randomUUID;
    }

}
