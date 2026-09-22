package com.webcodein.cqrs.query;

import com.webcodein.cqrs.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderQueryService {

    private final OrderSummaryRepository summaryRepository;

    public OrderQueryService(OrderSummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @KafkaListener(topics = "order-events", groupId = "query-group")
    @Transactional
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        OrderSummaryView summary = new OrderSummaryView(
            event.orderId(),
            event.customerId(),
            event.totalAmount(),
            "Pending Fulfillment"
        );
        summaryRepository.save(summary);
    }

    public List<OrderSummaryView> getCustomerOrders(String customerId) {
        return summaryRepository.findByCustomerId(customerId);
    }
}
