package com.webcodein.hexagonal.infrastructure.adapter.out.persistence;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, String> {
}
