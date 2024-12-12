package com.shivansh.springboot.restful_web_services.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivansh.springboot.restful_web_services.models.Product;
import com.shivansh.springboot.restful_web_services.repositories.ProductRepo;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductRepo repo;

	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

	@PostMapping("/products")
	public ResponseEntity<String> insertProduct(@RequestBody Product product){
		Product prd = product;
		repo.save(prd);
		return ResponseEntity.ok("Product saved successfully..");
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		Product product = repo.findById(id).orElse(null);
		if (product == null) {
			return new ResponseEntity<>("Product Not Found!!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
	}
}
