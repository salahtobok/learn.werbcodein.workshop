package com.webcodein.workshop.dddmistakes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;
    private String status;

    protected Order() {} // For JPA

    public Order(UUID id) {
        this.id = id;
        this.status = "CREATED";
    }

    public void complete() {
        if (!"CREATED".equals(this.status)) {
            throw new IllegalStateException("Order must be created to complete");
        }
        this.status = "COMPLETED";
    }

    public UUID getId() { return id; }
    public String getStatus() { return status; }
}
