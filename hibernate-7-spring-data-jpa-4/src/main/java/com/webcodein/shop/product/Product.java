package com.webcodein.shop.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    // Natively maps to JSONB in PostgreSQL
    @JdbcTypeCode(SqlTypes.JSON)
    private ProductMetadata metadata;

    protected Product() {
    }

    public Product(Long id, String name, ProductMetadata metadata) {
        this.id = id;
        this.name = name;
        this.metadata = metadata;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductMetadata getMetadata() {
        return metadata;
    }
}
