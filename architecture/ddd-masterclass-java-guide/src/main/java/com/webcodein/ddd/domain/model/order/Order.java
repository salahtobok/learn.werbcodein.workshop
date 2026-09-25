package com.webcodein.ddd.domain.model.order;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    private UUID customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    private List<OrderItem> items = new ArrayList<>();

    protected Order() {
        // Required by Hibernate
    }

    public Order(UUID customerId) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.status = OrderStatus.PENDING;
    }

    public void addItem(UUID productId, int quantity, double price) {
        if (this.status != OrderStatus.PENDING) {
            throw new IllegalStateException("Cannot modify an order that is not pending.");
        }
        this.items.add(new OrderItem(productId, quantity, price));
    }
    
    public void confirm() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cannot confirm an empty order.");
        }
        this.status = OrderStatus.CONFIRMED;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }
}
