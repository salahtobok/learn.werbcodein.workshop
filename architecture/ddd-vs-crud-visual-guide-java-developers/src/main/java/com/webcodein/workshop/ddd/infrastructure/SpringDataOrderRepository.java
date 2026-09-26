package com.webcodein.workshop.ddd.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, Long> {}
