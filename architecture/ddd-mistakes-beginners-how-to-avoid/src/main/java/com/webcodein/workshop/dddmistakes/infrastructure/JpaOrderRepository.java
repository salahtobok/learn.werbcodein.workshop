package com.webcodein.workshop.dddmistakes.infrastructure;

import com.webcodein.workshop.dddmistakes.domain.Order;
import com.webcodein.workshop.dddmistakes.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaOrderRepository extends OrderRepository, JpaRepository<Order, UUID> {
}
