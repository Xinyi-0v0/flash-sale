package com.xinyi.flashsale.kafka;

import com.xinyi.flashsale.db.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(String topic, Order data){
        Message<Order> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
