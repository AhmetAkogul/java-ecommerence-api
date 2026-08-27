package com.ecommerence.ecommerence_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @DeleteMapping("/{id}")
        public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    } // urunleri silmek icin

    @PutMapping("/{id}")
        public Product updateProduct(
        @PathVariable Long id,
        @RequestBody Product updatedProduct) {
    return productService.updateProduct(id, updatedProduct);
    } // urunleri guncellemek icin


    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
    return productService.searchProducts(name);
    } // urunleri aramak için
}

// .\mvnw.cmd spring-boot:run