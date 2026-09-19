package com.webcodein.shop.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Sets, not Lists: fetching two List ("bag") collections together throws MultipleBagFetchException
    @OneToMany(cascade = CascadeType.ALL)
    private Set<LineItem> lineItems = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Discount> discounts = new LinkedHashSet<>();

    protected Order() {
    }

    public Order(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }
}
