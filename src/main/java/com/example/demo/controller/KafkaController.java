//docker compose up -d and docker compose down to shut kafka.
// after starting docker/kafka, run spring boot and use kafka api.

package com.example.demo.controller;

import com.example.demo.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Message;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producer;

    public KafkaController(KafkaProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Message message) {
        producer.send(message.getMessage());
        return "Sent: " + message.getMessage();
    }
}
