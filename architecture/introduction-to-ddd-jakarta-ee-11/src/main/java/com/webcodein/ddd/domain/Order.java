package com.webcodein.ddd.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    @Embedded
    private Address shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    private String status;

    protected Order() {
        // JPA requirement
    }

    public Order(Address shippingAddress) {
        this.id = UUID.randomUUID();
        this.shippingAddress = shippingAddress;
        this.status = "PENDING";
    }

    public void addItem(OrderItem item) {
        if (!"PENDING".equals(this.status)) {
            throw new IllegalStateException("Cannot add items to an order that is not PENDING");
        }
        this.items.add(item);
    }

    public void confirm() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cannot confirm an order with no items");
        }
        this.status = "CONFIRMED";
    }

    public void ship() {
        if (!"CONFIRMED".equals(this.status)) {
            throw new IllegalStateException("Order must be CONFIRMED before it can be SHIPPED");
        }
        this.status = "SHIPPED";
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public UUID getId() {
        return id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getStatus() {
        return status;
    }
}
