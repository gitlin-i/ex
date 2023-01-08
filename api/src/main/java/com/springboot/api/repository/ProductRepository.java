package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
