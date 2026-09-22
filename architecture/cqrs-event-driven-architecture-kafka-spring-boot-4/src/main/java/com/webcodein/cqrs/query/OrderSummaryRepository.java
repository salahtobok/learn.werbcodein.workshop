package com.webcodein.cqrs.query;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderSummaryRepository extends JpaRepository<OrderSummaryView, Long> {
    List<OrderSummaryView> findByCustomerId(String customerId);
}
