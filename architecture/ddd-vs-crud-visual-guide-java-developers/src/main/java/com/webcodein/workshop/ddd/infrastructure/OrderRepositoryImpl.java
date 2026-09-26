package com.webcodein.workshop.ddd.infrastructure;
import com.webcodein.workshop.ddd.domain.Order;
import com.webcodein.workshop.ddd.domain.OrderRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final SpringDataOrderRepository jpaRepo;

    public OrderRepositoryImpl(SpringDataOrderRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = new OrderJpaEntity();
        entity.setId(order.getId());
        entity.setCustomerEmail(order.getCustomerEmail());
        entity.setTotalAmount(order.getTotalAmount());
        entity.setStatus(order.getStatus().name());
        
        OrderJpaEntity saved = jpaRepo.save(entity);
        return new Order(saved.getId(), saved.getCustomerEmail(), saved.getTotalAmount(), Order.OrderStatus.valueOf(saved.getStatus()));
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jpaRepo.findById(id).map(e -> 
            new Order(e.getId(), e.getCustomerEmail(), e.getTotalAmount(), Order.OrderStatus.valueOf(e.getStatus()))
        );
    }
}
