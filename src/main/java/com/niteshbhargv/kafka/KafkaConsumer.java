package com.niteshbhargv.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumer message: " + message);
    }
}
