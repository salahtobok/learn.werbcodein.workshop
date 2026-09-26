package com.webcodein.workshop.ddd.step1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "orders_step1")
public class Order {
    @Id private UUID id;
    private String status;
    private BigDecimal totalAmount;
    protected Order() {}
    public Order(UUID id) { this.id = id; this.status = "CREATED"; this.totalAmount = BigDecimal.ZERO; }
    public void addAmount(BigDecimal amount) {
        if (!"CREATED".equals(this.status)) throw new IllegalStateException("Not in CREATED status");
        this.totalAmount = this.totalAmount.add(amount);
    }
}