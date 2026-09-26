package com.webcodein.workshop.dddmistakes.domain;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void shouldCompleteOrder() {
        Order order = new Order(UUID.randomUUID());
        order.complete();
        assertEquals("COMPLETED", order.getStatus());
    }
}
