package com.curso.microservicios.currencyexchangeservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    @RabbitListener(queues="${limits-event.rabbitmq.queue}")
    public void receiveMessage(Configuration message) {
        System.out.println("Received <" + message + ">");
    }

}
