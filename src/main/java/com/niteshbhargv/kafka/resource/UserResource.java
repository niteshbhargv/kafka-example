package com.niteshbhargv.kafka.resource;

import com.niteshbhargv.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {



    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateV1;

    public static final String TOPIC = "Kafka_example";


    @GetMapping("/publish/{message}")
    public String publishMessageV1(@PathVariable("message") final String message) {
        System.out.println("publishing message");
        kafkaTemplateV1.send(TOPIC, new User(message, "fd",23123L));
        return "published successfully";
    }
}
