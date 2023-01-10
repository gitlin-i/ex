package com.springboot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.ChangeProductNameDTO;
import com.springboot.api.dto.ProductDTO;
import com.springboot.api.dto.ProductResponseDTO;
import com.springboot.api.service.ProductService;


import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    
    public ResponseEntity<ProductResponseDTO> getProduct(@Parameter(name = "number") Long number){
        ProductResponseDTO productResponseDTO = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct( @RequestBody ProductDTO productDTO) {
        ProductResponseDTO productResponseDTO = productService.saveProduct(productDTO);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PutMapping
    public ResponseEntity<ProductResponseDTO> changeProductName(
        @RequestBody ChangeProductNameDTO changeProductNameDTO
    ) throws Exception {
        ProductResponseDTO productResponseDTO = productService.changeProductName(
            changeProductNameDTO.getNumber(),
            changeProductNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct( @Parameter(name = "number") Long number) throws Exception {
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

}
