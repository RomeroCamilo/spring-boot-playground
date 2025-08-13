package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "demo-group")
    public void consume(String message) {
        System.out.println("[KafkaConsumer] Received: " + message);
    }
}
