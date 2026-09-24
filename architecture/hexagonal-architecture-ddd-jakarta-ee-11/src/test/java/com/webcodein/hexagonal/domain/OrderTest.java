package com.webcodein.hexagonal.domain;

import com.webcodein.hexagonal.domain.model.Money;
import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.model.OrderId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCreateOrderWithInitialState() {
        Order order = new Order(new OrderId("123"), "CUST-1", new Money(new BigDecimal("100.00")));
        
        assertEquals("123", order.getId().value());
        assertEquals("CUST-1", order.getCustomerId());
        assertEquals(Order.OrderStatus.CREATED, order.getStatus());
        assertNotNull(order.getCreatedAt());
    }

    @Test
    void shouldTransitionToPaidState() {
        Order order = new Order(new OrderId("123"), "CUST-1", new Money(new BigDecimal("100.00")));
        order.pay();
        
        assertEquals(Order.OrderStatus.PAID, order.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenPayingAlreadyPaidOrder() {
        Order order = new Order(new OrderId("123"), "CUST-1", new Money(new BigDecimal("100.00")));
        order.pay();
        
        assertThrows(IllegalStateException.class, order::pay);
    }
}
