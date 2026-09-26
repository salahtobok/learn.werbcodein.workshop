package com.webcodein.boundedcontext.catalog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private UUID id;
    private String name;
    private double price;

    public Product() {}

    public Product(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
