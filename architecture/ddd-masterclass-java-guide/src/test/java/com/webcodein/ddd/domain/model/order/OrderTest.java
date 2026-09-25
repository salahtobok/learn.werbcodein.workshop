package com.webcodein.ddd.domain.model.order;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void newOrderIsPending() {
        Order order = new Order(UUID.randomUUID());
        assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    void canAddItemToPendingOrder() {
        Order order = new Order(UUID.randomUUID());
        order.addItem(UUID.randomUUID(), 2, 10.5);
        assertEquals(1, order.getItems().size());
    }

    @Test
    void cannotConfirmEmptyOrder() {
        Order order = new Order(UUID.randomUUID());
        assertThrows(IllegalStateException.class, order::confirm);
    }

    @Test
    void canConfirmOrderWithItems() {
        Order order = new Order(UUID.randomUUID());
        order.addItem(UUID.randomUUID(), 2, 10.5);
        order.confirm();
        assertEquals(OrderStatus.CONFIRMED, order.getStatus());
    }

    @Test
    void cannotAddItemToConfirmedOrder() {
        Order order = new Order(UUID.randomUUID());
        order.addItem(UUID.randomUUID(), 2, 10.5);
        order.confirm();
        assertThrows(IllegalStateException.class, () -> order.addItem(UUID.randomUUID(), 1, 5.0));
    }
}
