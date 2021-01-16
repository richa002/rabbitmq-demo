package com.example.rabbitmqexample;

import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private final static Logger LOGGER_ = LogManager.getLogger(MessageController.class);


    @RabbitListener(queues = "spring-boot-queue")
    public void receiveMessage(OtpMessage otpMessage) throws InterruptedException {
        Thread.sleep(20000);
        LOGGER_.info("Received message asynchronously ........{}", otpMessage.toString());

    }


}