package com.ecommerence.ecommerence_api.dto;

import java.time.LocalDateTime;

public class OrderResponse {

    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private LocalDateTime createdAt;

    public OrderResponse(
            Long id,
            Long productId,
            String productName,
            int quantity,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.createdAt = createdAt;
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
}