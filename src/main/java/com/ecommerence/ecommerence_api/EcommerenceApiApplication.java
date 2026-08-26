package com.ecommerence.ecommerence_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerenceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerenceApiApplication.class, args);
    }
}

//@RestController sınıflarını bulur, @Service sınıflarını bulur, JpaRepository sınıflarını hazırlar, @Entity sınıflarından tabloları oluşturur, application.properties ayarlarını okur,