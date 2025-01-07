package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.producer.KafkaJsonProducer;
import com.example.demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    public MessageController(KafkaJsonProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    private final KafkaJsonProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
         //kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent successfully");
    }
}
