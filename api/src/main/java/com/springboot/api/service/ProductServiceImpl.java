package com.springboot.api.service;

import org.springframework.stereotype.Service;

import com.springboot.api.domain.Product;
import com.springboot.api.dto.ProductDTO;
import com.springboot.api.dto.ProductResponseDTO;
import com.springboot.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO getProduct(Long number) {
        log.info("[getProduct] input number : {}",number);
        Product product = productRepository.findById(number).get();

        log.info("[getProduct] product number : {}, name : {}",
        product.getNumber(), product.getName());

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
            .number(product.getNumber())
            .name(product.getName())
            .price(product.getPrice())
            .stock(product.getStock())
            .build();
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {
        log.info("[saveProduct] productDTO : {}", productDTO.toString());
        Product product = Product.builder()
        .name(productDTO.getName())
        .price(productDTO.getPrice())
        .stock(productDTO.getStock())
        .build();

        Product savedProduct = productRepository.save(product);
        log.info("[saveProduct] savedProduct : {}", savedProduct);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
            .number(savedProduct.getNumber())
            .name(savedProduct.getName())
            .price(savedProduct.getPrice())
            .stock(savedProduct.getStock())
            .build();

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        Product founProduct = productRepository.findById(number).get();
        founProduct.setName(name);
        Product changedProduct = productRepository.save(founProduct);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
            .number(changedProduct.getNumber())
            .name(changedProduct.getName())
            .price(changedProduct.getPrice())
            .stock(changedProduct.getStock())
            .build();

        return productResponseDTO;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
        
    }
    
}
