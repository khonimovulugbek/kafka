package org.apache.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/29/2024 11:31 PM
 * Info:
 */
@Component
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(Map<String, Object> message) {
        log.info("Received: {} ", message);
    }
}
