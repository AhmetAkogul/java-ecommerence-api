package com.ecommerence.ecommerence_api.dto;
import com.ecommerence.ecommerence_api.model.Category;

public class ProductResponse {

    private Long id;
    private String name;
    private double price;
    private int stock;
    private Category category;

    public ProductResponse(
        Long id,
        String name,
        double price,
        int stock,
        Category category
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    public Category getCategory() {
        return category;
    }
}