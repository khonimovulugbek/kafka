package org.apache.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/29/2024 11:26 PM
 * Info:
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageProducer {
    private final KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

    public void send(String topicName, String message) {
        Map<String, Object> props = new HashMap<>();
        props.put(topicName, message);
        kafkaTemplate.send(topicName, props);
        System.out.println("Message sent to topic: " + topicName);

    }
}
