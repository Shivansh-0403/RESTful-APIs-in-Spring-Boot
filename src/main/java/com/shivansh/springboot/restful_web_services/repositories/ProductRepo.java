package com.shivansh.springboot.restful_web_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivansh.springboot.restful_web_services.models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
