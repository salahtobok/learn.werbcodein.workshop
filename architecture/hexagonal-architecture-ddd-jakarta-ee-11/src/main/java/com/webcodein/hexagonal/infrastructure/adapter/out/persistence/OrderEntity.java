package com.webcodein.hexagonal.infrastructure.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;
    private String customerId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;

    // JPA requires no-arg constructor
    protected OrderEntity() {}

    public OrderEntity(String id, String customerId, BigDecimal amount, String status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters omitted for brevity, but let's add getters
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public BigDecimal getAmount() { return amount; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
