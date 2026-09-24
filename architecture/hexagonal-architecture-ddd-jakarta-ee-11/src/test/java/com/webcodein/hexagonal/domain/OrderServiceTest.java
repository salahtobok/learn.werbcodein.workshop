package com.webcodein.hexagonal.domain;

import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.port.out.OrderPort;
import com.webcodein.hexagonal.domain.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderPort orderPort;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderPort);
    }

    @Test
    void shouldCreateAndSaveOrder() {
        when(orderPort.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        Order order = orderService.createOrder("CUST-1", new BigDecimal("50.00"));

        assertEquals("CUST-1", order.getCustomerId());
        assertEquals(new BigDecimal("50.00"), order.getTotalAmount().amount());
        verify(orderPort).save(any(Order.class));
    }
}
