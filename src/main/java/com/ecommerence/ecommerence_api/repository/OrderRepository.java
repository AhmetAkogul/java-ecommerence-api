package com.ecommerence.ecommerence_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerence.ecommerence_api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}