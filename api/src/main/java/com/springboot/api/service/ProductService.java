package com.springboot.api.service;

import com.springboot.api.dto.ProductDTO;
import com.springboot.api.dto.ProductResponseDTO;

public interface ProductService {
    
    ProductResponseDTO getProduct(Long number);
    ProductResponseDTO saveProduct(ProductDTO productDTO);
    ProductResponseDTO changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
    
}
