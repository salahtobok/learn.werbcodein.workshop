package com.webcodein.shop.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Two Lists ("bags") fetched together is what used to cause MultipleBagFetchException
    @OneToMany(cascade = CascadeType.ALL)
    private List<LineItem> lineItems = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Discount> discounts = new ArrayList<>();

    protected Order() {
    }

    public Order(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
