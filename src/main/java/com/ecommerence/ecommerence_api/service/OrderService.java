package com.ecommerence.ecommerence_api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerence.ecommerence_api.dto.OrderRequest;
import com.ecommerence.ecommerence_api.dto.OrderResponse;
import com.ecommerence.ecommerence_api.model.Order;
import com.ecommerence.ecommerence_api.model.Product;
import com.ecommerence.ecommerence_api.repository.OrderRepository;
import com.ecommerence.ecommerence_api.repository.ProductRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(
            OrderRepository orderRepository,
            ProductRepository productRepository
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        if (request.getProductId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Product ID is required"
            );
        }

        if (request.getQuantity() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Quantity must be upper than 0"
            );
        }

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"
                ));

        if (product.getStock() < request.getQuantity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Insufficient stock"
            );
        }

        product.setStock(product.getStock() - request.getQuantity());
        productRepository.save(product);

        Order order = new Order(product, request.getQuantity());
        Order savedOrder = orderRepository.save(order);

        return toOrderResponse(savedOrder);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toOrderResponse)
                .toList();
    }

    private OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProduct().getId(),
                order.getProduct().getName(),
                order.getQuantity(),
                order.getCreatedAt()
        );
    }
}