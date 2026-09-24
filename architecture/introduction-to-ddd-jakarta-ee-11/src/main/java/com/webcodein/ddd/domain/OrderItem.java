package com.webcodein.ddd.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private UUID id;

    private String productName;
    private int quantity;
    private BigDecimal price;

    protected OrderItem() {
        // JPA requirement
    }

    public OrderItem(String productName, int quantity, BigDecimal price) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = UUID.randomUUID();
        this.productName = Objects.requireNonNull(productName);
        this.quantity = quantity;
        this.price = Objects.requireNonNull(price);
    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
