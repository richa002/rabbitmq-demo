package com.example.rabbitmqexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class MessageController {
    @Autowired
    Sender sender;

    @PostMapping("/sendMessageToCustomer")
    public String sendMessage(@RequestBody OtpMessage otpMessage) {
        try {

            sender.send(otpMessage);

        } catch (Exception e) {
            return "Message could not be send successfully";
        }
        return "Message send successfully";
    }
}
