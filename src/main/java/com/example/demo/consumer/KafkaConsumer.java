package com.example.demo.consumer;

import com.example.demo.entity.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class KafkaConsumer {

    //@KafkaListener(topics = "asmaaHr", groupId = "myGroup")
    public void consumeMsg(String msg) {
        System.out.println("Consuming msg from topic asmaaHr");
        System.out.println(format("Message : %s", msg));

    }

    @KafkaListener(topics = "asmaaHr", groupId = "myGroup")
    public void MyconsumeMsg(Student msg) {
        System.out.println("Consuming msg from topic asmaaHr");
        System.out.println(format("Message : %s", msg.toString()));

    }
}
