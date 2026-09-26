package com.webcodein.workshop.ddd.domain;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testValidOrderCreation() {
        Order order = new Order("test@example.com", new BigDecimal("100.00"));
        assertEquals(Order.OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Order("invalid-email", new BigDecimal("100.00"))
        );
    }
}
