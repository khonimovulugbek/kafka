package org.apache.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/29/2024 11:25 PM
 * Info:
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaController {
    private final MessageProducer messageProducer;
    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.send("my-topic", message);
        return "OK";
    }
    @GetMapping("/send")
    public String sendMessageParam(@RequestParam("message") String message) {
        messageProducer.send("my-topic", message);
        return message;
    }

}
