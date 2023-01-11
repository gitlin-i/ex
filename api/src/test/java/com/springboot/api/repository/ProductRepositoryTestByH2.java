package com.springboot.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.api.domain.Product;

@DataJpaTest
public class ProductRepositoryTestByH2 {
    
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest() {
        Product product = Product.builder()
            .name("펜")
            .price(1000)
            .stock(1000)
            .build();

        Product saveProduct = productRepository.save(product);

        assertEquals(product.getName(), saveProduct.getName());
        assertEquals(product.getPrice(), saveProduct.getPrice());
        assertEquals(product.getStock(), saveProduct.getStock());

    }

    @Test
    void selectTest() {
        Product product = Product.builder()
            .name("펜")
            .price(1000)
            .stock(1000)
            .build();

        Product saveProduct = productRepository.saveAndFlush(product);

        Product foundProduct = productRepository.findById(saveProduct.getNumber()).get();

        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());

    }
}
