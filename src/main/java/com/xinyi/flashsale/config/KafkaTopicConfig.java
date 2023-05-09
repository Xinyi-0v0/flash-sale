package com.xinyi.flashsale.config;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("testTopic")
                .build();
    }

    @Bean
    public NewTopic createOrder() {
        return TopicBuilder.name("create_order")
                .build();
    }

    @Bean
    public NewTopic checkOrderStatus() {
        return TopicBuilder.name("pay_check")
                .build();
    }

    @Bean
    public NewTopic afterPayment() {
        return TopicBuilder.name("pay_done")
                .build();
    }

}

