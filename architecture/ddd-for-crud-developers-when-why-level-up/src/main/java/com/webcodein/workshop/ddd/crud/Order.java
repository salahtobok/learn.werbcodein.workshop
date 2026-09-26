package com.webcodein.workshop.ddd.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;
    private String status;
    private BigDecimal totalAmount;

    public Order() {
        this.id = UUID.randomUUID();
        this.status = "CREATED";
        this.totalAmount = BigDecimal.ZERO;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
}
