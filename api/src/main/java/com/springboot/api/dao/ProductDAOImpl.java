package com.springboot.api.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springboot.api.domain.Product;
import com.springboot.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO{
    private final ProductRepository productRepository;

    @Override
    public Product insertProduct(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number){
        Product selectedProduct = productRepository.findById(number).get();
        return selectedProduct;
    }


    @Override
    public Product updateProductName(Long number, String name) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        }else{
            throw new Exception();
        }

        return updatedProduct;
    }
    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else{
            throw new Exception();
        }
    }
}
