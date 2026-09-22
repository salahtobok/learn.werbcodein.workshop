package com.webcodein.cqrs.event;

public record OrderCreatedEvent(Long orderId, String customerId, Double totalAmount) {}
