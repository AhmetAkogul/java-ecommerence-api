package com.ecommerence.ecommerence_api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerence.ecommerence_api.dto.ProductRequest;
import com.ecommerence.ecommerence_api.dto.ProductResponse;
import com.ecommerence.ecommerence_api.model.Category;
import com.ecommerence.ecommerence_api.model.Product;
import com.ecommerence.ecommerence_api.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toProductResponse)
                .toList();
    }

    public ProductResponse createProduct(ProductRequest request) {
        validateProductRequest(request);

        Product product = new Product(
            request.getName(),
            request.getPrice(),
            request.getStock(),
            request.getCategory()
        );

        return toProductResponse(productRepository.save(product));
    }

    public ProductResponse getProductById(Long id) {
        return toProductResponse(findProductById(id));
    }

    public void deleteProductById(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    } // ürünlerin silinmesi için method

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        validateProductRequest(request);

        Product product = findProductById(id);

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());

        return toProductResponse(productRepository.save(product));
    } // ürünlerin güncellenmesi için method

    private void validateProductRequest(ProductRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Product Name Cant Be Empty"
            );
        }

        if (request.getStock() < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Stock Value Cant Be Negative"
            );
        }

        if (request.getPrice() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Product Price Cant Be Lower Than 0"
            );
        }

        if (request.getCategory() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Product Category Cant Be Empty"
            );
        }
    }

    public List<ProductResponse> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::toProductResponse)
                .toList();
    } // ürünlerin aranması /products/search?name=ürünismi

    public List<ProductResponse> getProductsByCategory(Category category) {
    return productRepository.findByCategory(category)
            .stream()
            .map(this::toProductResponse)
            .toList();
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ürün bulunamadı"
                ));
    }

    private ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCategory()
        );
    }
}