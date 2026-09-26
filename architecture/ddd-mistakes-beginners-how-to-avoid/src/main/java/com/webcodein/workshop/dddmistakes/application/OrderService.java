package com.webcodein.workshop.dddmistakes.application;

import com.webcodein.workshop.dddmistakes.domain.Order;
import com.webcodein.workshop.dddmistakes.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository = repository; }

    @Transactional
    public void completeOrder(UUID orderId) {
        Order order = repository.findById(orderId).orElseThrow();
        order.complete();
        repository.save(order);
    }
}
