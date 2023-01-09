package com.springboot.api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.springboot.api.dao.ProductDAO;
import com.springboot.api.domain.Product;
import com.springboot.api.dto.ProductDTO;
import com.springboot.api.dto.ProductResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductDAO productDAO;

    @Override
    public ProductResponseDTO getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(product.getNumber());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        // ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        // productResponseDTO.setName(savedProduct.getName());
        // productResponseDTO.setName(savedProduct.getName());
        // productResponseDTO.setPrice(savedProduct.getPrice());
        // productResponseDTO.setStock(savedProduct.getStock());

        ProductResponseDTO productResponseDTO2 = ProductResponseDTO.builder()
            .name(savedProduct.getName())
            .number(savedProduct.getNumber())
            .price(savedProduct.getPrice())
            .stock(savedProduct.getStock())
            .build();

        return productResponseDTO2;
    }

    @Override
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

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
        productDAO.deleteProduct(number);
        
    }
    
}
