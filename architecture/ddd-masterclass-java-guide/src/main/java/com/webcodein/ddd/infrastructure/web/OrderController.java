package com.webcodein.ddd.infrastructure.web;

import com.webcodein.ddd.application.service.OrderApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public ResponseEntity<UUID> createOrder(@RequestParam UUID customerId) {
        UUID orderId = orderApplicationService.createOrder(customerId);
        return ResponseEntity.ok(orderId);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Void> addItem(@PathVariable UUID orderId,
                                        @RequestParam UUID productId,
                                        @RequestParam int quantity,
                                        @RequestParam double price) {
        orderApplicationService.addProductToOrder(orderId, productId, quantity, price);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<Void> confirmOrder(@PathVariable UUID orderId) {
        orderApplicationService.confirmOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
