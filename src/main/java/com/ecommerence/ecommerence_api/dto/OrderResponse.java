package com.ecommerence.ecommerence_api.dto;
import java.time.LocalDateTime;

import com.ecommerence.ecommerence_api.model.OrderStatus;


public class OrderResponse {

    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private LocalDateTime createdAt;
    private OrderStatus status;

    public OrderResponse(
            Long id,
            Long productId,
            String productName,
            int quantity,
            LocalDateTime createdAt,
            OrderStatus status
    ) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }
}