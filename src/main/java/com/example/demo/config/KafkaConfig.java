package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${app.kafka.topic}")
    private String topicName;

    // Creates the topic if auto-creation is enabled on the broker.
    @Bean
    public NewTopic demoTopic() {
        return new NewTopic(topicName, 1, (short) 1);
    }
}
