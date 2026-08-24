package com.ecommerence.ecommerence_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerence.ecommerence_api.model.Product;
import com.ecommerence.ecommerence_api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
        public Product createProduct(@RequestBody Product product) {
    return productService.createProduct(product);
    }

    @GetMapping("/{id}")
        public Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
    }
}