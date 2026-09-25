package com.webcodein.ddd.application.service;

import com.webcodein.ddd.domain.model.order.Order;
import com.webcodein.ddd.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderApplicationService {

    private final OrderRepository orderRepository;

    public OrderApplicationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public UUID createOrder(UUID customerId) {
        Order order = new Order(customerId);
        return orderRepository.save(order).getId();
    }

    @Transactional
    public void addProductToOrder(UUID orderId, UUID productId, int quantity, double price) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        order.addItem(productId, quantity, price);
        orderRepository.save(order);
    }

    @Transactional
    public void confirmOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        order.confirm();
        orderRepository.save(order);
    }
}
