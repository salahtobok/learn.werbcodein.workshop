package com.webcodein.shop.order;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @EntityGraph(attributePaths = {"lineItems", "discounts"})
    List<Order> findByStatus(OrderStatus status);
}
