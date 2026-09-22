package com.webcodein.cqrs.command;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerId;
    private Double totalAmount;
    private String status;

    public Order() {}

    public Order(String customerId, Double totalAmount, String status) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getCustomerId() { return customerId; }
    public Double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
}
