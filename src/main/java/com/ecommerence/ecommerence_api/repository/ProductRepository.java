package com.ecommerence.ecommerence_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerence.ecommerence_api.model.Category;
import com.ecommerence.ecommerence_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);
}


/* JpaRepository<Product, Long> metotlari:
 * findAll()
 * findById(id)
 * save(product)
 * deleteById(id)
 *
 * Product: islem yapilacak veri türü
 * Long: product sınıfındaki id
 */