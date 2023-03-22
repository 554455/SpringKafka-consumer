package com.umaraliev.consumer.service;

import com.umaraliev.consumer.model.User;
import com.umaraliev.consumer.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "${topics}", groupId = "${group_id_config}")
    public void consume(@Email User user) {
        emailService.send(user,  "Subjects message", "Body message + ");
        log.info("The data came in");
    }
}
