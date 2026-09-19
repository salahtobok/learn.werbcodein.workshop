package com.webcodein.shop.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Discount {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    protected Discount() {
    }

    public Discount(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
