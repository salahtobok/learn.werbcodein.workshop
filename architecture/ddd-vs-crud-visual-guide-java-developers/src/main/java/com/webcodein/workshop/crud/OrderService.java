package com.webcodein.workshop.crud;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderEntity createOrder(String email, BigDecimal amount) {
        OrderEntity order = new OrderEntity();
        order.setCustomerEmail(email);
        order.setTotalAmount(amount);
        order.setStatus("CREATED");
        return repository.save(order);
    }
    
    public void fulfillOrder(Long id) {
        Optional<OrderEntity> orderOpt = repository.findById(id);
        if (orderOpt.isPresent()) {
            OrderEntity order = orderOpt.get();
            if (order.getStatus().equals("CREATED")) {
                order.setStatus("FULFILLED");
                repository.save(order);
            } else {
                throw new IllegalStateException("Cannot fulfill");
            }
        }
    }
}
