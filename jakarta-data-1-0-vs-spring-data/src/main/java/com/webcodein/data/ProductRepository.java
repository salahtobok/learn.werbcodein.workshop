package com.webcodein.data;

import jakarta.data.Order;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Paginated results; the sort order is a separate parameter in Jakarta Data 1.0
    Page<Product> findByCategory(String category, PageRequest pageRequest, Order<Product> order);
}
