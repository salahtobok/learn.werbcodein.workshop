package com.webcodein.hexagonal.domain.model;

public record OrderId(String value) {
    public OrderId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("OrderId cannot be empty");
        }
    }
}
