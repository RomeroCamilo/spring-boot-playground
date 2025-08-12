package com.example.demo.service;
import com.example.demo.service.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RandomGeneratorTest {

    private final RandomGenerator randomGenerator = new RandomGenerator();

    @Test
    public void randomUUID() {
        String randomUUID = randomGenerator.randomUUID();
        assertNotNull(randomUUID, "UUID should not be null");
        System.out.println("Generated: " + randomUUID);
    }
}
