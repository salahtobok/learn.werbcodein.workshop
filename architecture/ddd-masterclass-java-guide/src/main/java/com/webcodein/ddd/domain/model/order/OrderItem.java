package com.webcodein.ddd.domain.model.order;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record OrderItem(UUID productId, int quantity, double price) {
    public OrderItem {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
