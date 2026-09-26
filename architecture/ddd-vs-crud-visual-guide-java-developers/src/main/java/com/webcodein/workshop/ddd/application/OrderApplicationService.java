package com.webcodein.workshop.ddd.application;
import com.webcodein.workshop.ddd.domain.Order;
import com.webcodein.workshop.ddd.domain.OrderRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderApplicationService {
    private final OrderRepository repository;

    public OrderApplicationService(OrderRepository repository) {
        this.repository = repository;
    }

    public Long createOrder(String email, BigDecimal amount) {
        Order order = new Order(email, amount);
        Order saved = repository.save(order);
        return saved.getId();
    }

    public void fulfillOrder(Long id) {
        Order order = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Not found"));
        order.fulfill();
        repository.save(order);
    }
}
