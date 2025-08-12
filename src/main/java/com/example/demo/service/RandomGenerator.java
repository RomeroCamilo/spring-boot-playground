package com.example.demo.service;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomGenerator {

    public String randomUUID(){
        return UUID.randomUUID().toString();
    }
}
