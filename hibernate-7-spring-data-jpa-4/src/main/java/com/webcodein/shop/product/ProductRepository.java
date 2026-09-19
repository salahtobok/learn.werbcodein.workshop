package com.webcodein.shop.product;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // Querying directly inside the JSON column
    @Query("SELECT p FROM Product p WHERE p.metadata.manufacturer = :manufacturer")
    List<Product> findByManufacturer(String manufacturer);
}
