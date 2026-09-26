package com.webcodein.workshop.architecture.ddd.domain.model.order;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_lines")
public class OrderLine {
    @Id
    private UUID id;
    private String bookId;
    private int quantity;

    protected OrderLine() {}

    public OrderLine(UUID id, String bookId, int quantity) {
        this.id = id;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public UUID getId() { return id; }
    public String getBookId() { return bookId; }
    public int getQuantity() { return quantity; }
}
