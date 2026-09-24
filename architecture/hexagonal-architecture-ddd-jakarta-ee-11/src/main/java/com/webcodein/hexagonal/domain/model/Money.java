package com.webcodein.hexagonal.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount) {
    public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount()));
    }
}
