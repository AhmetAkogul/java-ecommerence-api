package com.ecommerence.ecommerence_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerence.ecommerence_api.model.Product;

@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {

        Product product1 = new Product( 1L, "Laptop", 25000 );
        Product product2 = new Product( 2L, "Mouse", 1500 );

        products = List.of(product1, product2);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(Long id) {

        for (Product product : products) {

            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }
}