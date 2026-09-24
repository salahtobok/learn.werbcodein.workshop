package com.webcodein.hexagonal.domain.port.out;

import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.model.OrderId;
import java.util.Optional;

public interface OrderPort {
    Order save(Order order);
    Optional<Order> findById(OrderId id);
}
