package com.ecommerence.ecommerence_api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerence.ecommerence_api.model.Product;
import com.ecommerence.ecommerence_api.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        validateProduct(product); // validateproduct a dogrulatıyoruz
    return productRepository.save(product);
    }


    public Product getProductById(Long id) {
    return productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Ürün bulunamadı"
            ));
    }


    public void deleteProductById(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    } // ürünlerin silinmesi icin method


    public Product updateProduct(Long id, Product updatedProduct) {
        validateProduct(updatedProduct);
        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

    return productRepository.save(product);
    } // ürünlerin güncellenmesi icin method





private void validateProduct(Product product) {
    if (product.getName() == null || product.getName().isBlank()) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Product Name Cant Be Empty"
        );
    }

    if (product.getStock() < 0) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Stock Value Cant Be Negative"
        );
    }

    if (product.getPrice() <= 0) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Product Price Cant Be Lower Than 0"
        );
    }
}


    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    } // ürünlerin aranması /products/search?name=ürünismi


}