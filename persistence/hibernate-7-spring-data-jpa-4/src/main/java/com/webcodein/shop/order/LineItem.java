package com.webcodein.shop.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LineItem {

    @Id
    @GeneratedValue
    private Long id;

    private String sku;

    protected LineItem() {
    }

    public LineItem(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }
}
