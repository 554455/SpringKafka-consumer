package com.umaraliev.consumer.service;

import com.umaraliev.consumer.model.User;
import com.umaraliev.consumer.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume(User user) {
        emailService.send(user,  "HI!", "Hello + " + user.getEmail());
        System.out.println("userInfo = " + user.getEmail());
    }
}
