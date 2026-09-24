package com.webcodein.hexagonal.domain.service;

import com.webcodein.hexagonal.domain.model.Money;
import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.model.OrderId;
import com.webcodein.hexagonal.domain.port.in.CreateOrderUseCase;
import com.webcodein.hexagonal.domain.port.out.OrderPort;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.math.BigDecimal;
import java.util.UUID;

@Named
public class OrderService implements CreateOrderUseCase {

    private final OrderPort orderPort;

    @Inject
    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Order createOrder(String customerId, BigDecimal amount) {
        Order order = new Order(
            new OrderId(UUID.randomUUID().toString()),
            customerId,
            new Money(amount)
        );
        return orderPort.save(order);
    }
}
