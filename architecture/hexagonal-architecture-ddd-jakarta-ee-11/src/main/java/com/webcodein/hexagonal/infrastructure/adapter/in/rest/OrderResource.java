package com.webcodein.hexagonal.infrastructure.adapter.in.rest;

import com.webcodein.hexagonal.domain.model.Order;
import com.webcodein.hexagonal.domain.port.in.CreateOrderUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("/api/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private final CreateOrderUseCase createOrderUseCase;

    @Inject
    public OrderResource(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @POST
    public Response createOrder(OrderRequest request) {
        Order order = createOrderUseCase.createOrder(request.customerId(), request.amount());
        return Response.status(Response.Status.CREATED)
                .entity(new OrderResponse(order.getId().value(), order.getStatus().name()))
                .build();
    }

    public record OrderRequest(String customerId, BigDecimal amount) {}
    public record OrderResponse(String id, String status) {}
}
