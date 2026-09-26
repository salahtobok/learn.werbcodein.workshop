package com.webcodein.workshop.architecture.ddd.domain.model.order;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderLine> lines = new ArrayList<>();

    protected Order() {} // for JPA

    public Order(UUID id) {
        this.id = id;
    }

    public void addLine(OrderLine line) {
        this.lines.add(line);
    }

    public UUID getId() {
        return id;
    }

    public List<OrderLine> getLines() {
        return List.copyOf(lines);
    }
}
