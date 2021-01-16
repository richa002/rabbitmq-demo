package com.example.rabbitmqexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplateBean;
    private final static Logger LOGGER_ = LogManager.getLogger(MessageController.class);

    @Value("${richa.rabbitmq.routingkey}")
    String routingKey;

    @Value("${richa.rabbitmq.exchange}")
    String topicExchangeName;


    @Autowired
    private Receiver receiver;


    public void send(OtpMessage message) throws Exception {
        LOGGER_.info("Sending message asynchronously");
        rabbitTemplateBean.convertAndSend(topicExchangeName, routingKey, message);

    }

}