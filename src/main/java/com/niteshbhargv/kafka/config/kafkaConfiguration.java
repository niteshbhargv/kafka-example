package com.niteshbhargv.kafka.config;

import com.niteshbhargv.kafka.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConfiguration {

    /**
     * You don't need to redefine the KafkaTemplate, if you define a ProducerFactory it will be used in the autoconfigured
     * KafkaTemplate (see KafkaAutoConfiguration). In this example the whole ProducerFactory can be removed,
     * by adding the following property in application.yml
     * spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
     * */
    @Bean
    public ProducerFactory<String, User> producerFactory() {

        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //JSON Serializer should be from spring framework
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
