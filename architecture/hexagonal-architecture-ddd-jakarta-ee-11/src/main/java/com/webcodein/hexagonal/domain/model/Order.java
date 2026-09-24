package com.webcodein.hexagonal.domain.model;

import java.time.LocalDateTime;

public class Order {
    private final OrderId id;
    private final String customerId;
    private Money totalAmount;
    private OrderStatus status;
    private final LocalDateTime createdAt;

    public Order(OrderId id, String customerId, Money totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public void pay() {
        if (this.status != OrderStatus.CREATED) {
            throw new IllegalStateException("Only CREATED orders can be paid");
        }
        this.status = OrderStatus.PAID;
    }

    public OrderId getId() { return id; }
    public String getCustomerId() { return customerId; }
    public Money getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public enum OrderStatus {
        CREATED, PAID, CANCELLED, SHIPPED
    }
}
