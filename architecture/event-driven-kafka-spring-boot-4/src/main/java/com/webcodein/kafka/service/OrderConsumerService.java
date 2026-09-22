package com.webcodein.kafka.service;

import com.webcodein.kafka.config.KafkaTopicConfig;
import com.webcodein.kafka.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderConsumerService {

    private static final Logger log = LoggerFactory.getLogger(OrderConsumerService.class);
    private final List<OrderEvent> processedOrders = new ArrayList<>();

    @KafkaListener(topics = KafkaTopicConfig.ORDER_TOPIC, groupId = "order-group")
    public void consume(OrderEvent event) {
        log.info("Consumed order event: {}", event.getOrderId());
        processedOrders.add(event);
    }

    public List<OrderEvent> getProcessedOrders() {
        return processedOrders;
    }
}
