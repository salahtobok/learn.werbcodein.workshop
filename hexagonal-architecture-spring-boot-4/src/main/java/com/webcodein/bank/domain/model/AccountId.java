package com.webcodein.bank.domain.model;

public record AccountId(Long value) {

    public Long getValue() {
        return value;
    }
}
