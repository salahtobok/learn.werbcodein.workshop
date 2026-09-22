package com.webcodein.cqrs.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders/summary")
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderSummaryView>> getCustomerOrders(@PathVariable String customerId) {
        return ResponseEntity.ok(orderQueryService.getCustomerOrders(customerId));
    }
}
