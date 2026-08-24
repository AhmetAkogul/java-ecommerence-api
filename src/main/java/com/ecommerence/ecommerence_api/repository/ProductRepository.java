package com.ecommerence.ecommerence_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerence.ecommerence_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}