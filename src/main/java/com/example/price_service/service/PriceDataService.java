package com.example.price_service.service;

import com.example.price_service.dto.PriceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PriceDataService {
    private static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(PriceData priceData) {
        kafkaTemplate.send(TOPIC, String.valueOf(priceData));
        System.out.println("Message sent: " + priceData);
    }

    @KafkaListener(topics = "my_topic", groupId = "price")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
