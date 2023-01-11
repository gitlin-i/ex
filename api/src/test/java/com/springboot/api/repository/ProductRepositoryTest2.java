package com.springboot.api.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.api.domain.Product;

@SpringBootTest
public class ProductRepositoryTest2 {
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void basicCRUDTest() {
        Product givenProduct = Product.builder()
            .name("노트")
            .price(1000)
            .stock(500)
            .build();
        
        Product savedProduct = productRepository.save(givenProduct);

        Assertions.assertEquals(givenProduct.getNumber(), savedProduct.getNumber());
        Assertions.assertEquals(givenProduct.getName(), savedProduct.getName());
        Assertions.assertEquals(givenProduct.getPrice(), savedProduct.getPrice());
        Assertions.assertEquals(givenProduct.getStock(), savedProduct.getStock());

        Product selectedProduct = productRepository.findById(savedProduct.getNumber())
                                                .orElseThrow(RuntimeException::new);

        Assertions.assertEquals(givenProduct.getNumber(), selectedProduct.getNumber());
        Assertions.assertEquals(givenProduct.getName(), selectedProduct.getName());
        Assertions.assertEquals(givenProduct.getPrice(), selectedProduct.getPrice());
        Assertions.assertEquals(givenProduct.getStock(), selectedProduct.getStock());
        
        Product foundProduct = productRepository.findById(selectedProduct.getNumber())
                                                .orElseThrow(RuntimeException::new);

        foundProduct.setName("장난감");

        Product updatedProduct = productRepository.save(foundProduct);

        Assertions.assertEquals(updatedProduct.getName(), "장난감");

        productRepository.delete(updatedProduct);

        Assertions.assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());
    }

}
