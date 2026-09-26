package com.webcodein.workshop.ddd.crud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.UUID;
@Service
@Transactional
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository = repository; }
    public Order createOrder() { return repository.save(new Order()); }
    public void addAmount(UUID orderId, BigDecimal amount) {
        Order order = repository.findById(orderId).orElseThrow();
        if (!"CREATED".equals(order.getStatus())) throw new IllegalStateException("Order not in CREATED status");
        order.setTotalAmount(order.getTotalAmount().add(amount));
        repository.save(order);
    }
}