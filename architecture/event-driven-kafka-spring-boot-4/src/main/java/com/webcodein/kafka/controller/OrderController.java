package com.webcodein.kafka.controller;

import com.webcodein.kafka.model.OrderEvent;
import com.webcodein.kafka.service.OrderConsumerService;
import com.webcodein.kafka.service.OrderProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducerService producerService;
    private final OrderConsumerService consumerService;

    public OrderController(OrderProducerService producerService, OrderConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @PostMapping
    public OrderEvent createOrder(@RequestParam double amount) {
        return producerService.sendOrder(amount);
    }

    @GetMapping
    public List<OrderEvent> getProcessedOrders() {
        return consumerService.getProcessedOrders();
    }
}
