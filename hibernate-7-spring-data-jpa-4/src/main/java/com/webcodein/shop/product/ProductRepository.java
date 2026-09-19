package com.webcodein.shop.product;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // Querying inside the JSON column with the HQL json_value() function
    @Query("SELECT p FROM Product p WHERE json_value(p.metadata, '$.manufacturer') = :manufacturer")
    List<Product> findByManufacturer(String manufacturer);
}
