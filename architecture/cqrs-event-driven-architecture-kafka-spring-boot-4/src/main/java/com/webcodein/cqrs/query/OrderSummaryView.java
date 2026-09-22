package com.webcodein.cqrs.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_summary_view")
public class OrderSummaryView {

    @Id
    private Long orderId;
    private String customerId;
    private Double totalAmount;
    private String displayStatus;

    public OrderSummaryView() {}

    public OrderSummaryView(Long orderId, String customerId, Double totalAmount, String displayStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.displayStatus = displayStatus;
    }

    public Long getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public Double getTotalAmount() { return totalAmount; }
    public String getDisplayStatus() { return displayStatus; }
}
