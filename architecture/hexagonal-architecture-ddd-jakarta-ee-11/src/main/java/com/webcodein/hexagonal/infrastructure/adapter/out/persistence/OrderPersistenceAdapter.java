package com.webcodein.hexagonal.infrastructure.adapter.out.persistence;

import com.webcodein.hexagonal.domain.model.Money;
import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.model.OrderId;
import com.webcodein.hexagonal.domain.port.out.OrderPort;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Optional;

@Named
public class OrderPersistenceAdapter implements OrderPort {

    private final OrderRepository repository;

    @Inject
    public OrderPersistenceAdapter(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity(
            order.getId().value(),
            order.getCustomerId(),
            order.getTotalAmount().amount(),
            order.getStatus().name(),
            order.getCreatedAt()
        );
        repository.save(entity);
        return order; // In a real app, map back from saved entity if DB generates IDs
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return repository.findById(id.value()).map(this::mapToDomain);
    }

    private Order mapToDomain(OrderEntity entity) {
        // Reflection or package-private constructor would be used in a real app to restore state without triggering domain logic
        return new Order(
            new OrderId(entity.getId()),
            entity.getCustomerId(),
            new Money(entity.getAmount())
        );
    }
}
