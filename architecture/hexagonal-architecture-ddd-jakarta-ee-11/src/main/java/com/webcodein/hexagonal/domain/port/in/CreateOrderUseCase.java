package com.webcodein.hexagonal.domain.port.in;

import com.webcodein.hexagonal.domain.model.Order;

public interface CreateOrderUseCase {
    Order createOrder(String customerId, java.math.BigDecimal amount);
}
