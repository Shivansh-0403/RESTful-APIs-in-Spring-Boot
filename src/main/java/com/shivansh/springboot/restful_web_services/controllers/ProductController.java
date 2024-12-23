package com.shivansh.springboot.restful_web_services.controllers;

import java.io.IOException;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shivansh.springboot.restful_web_services.models.Product;
import com.shivansh.springboot.restful_web_services.repositories.ProductRepo;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductRepo repo;

	@GetMapping("/")
	public ResponseEntity<String> printHelloWorld(){
		return ResponseEntity.ok("Hello Programmer..");
	}

	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

	@PostMapping("/products")
	public ResponseEntity<?> insertProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile) throws IOException{
		try {
			if (imageFile == null){
				throw new Exception("Image not uploaded..");
			}

//			System.out.println(product.getName());
			Product prd = product;
			prd.setImageName(imageFile.getOriginalFilename());
			prd.setImageType(imageFile.getContentType());
			prd.setImageData(imageFile.getBytes());
			Product res = repo.save(prd);
			return new ResponseEntity<>(res, HttpStatus.CREATED);	
		}
		catch(Exception e) {
			System.out.println("Failed with error: "+e);
			return new ResponseEntity<>("Failed with error: "+e, HttpStatus.NOT_FOUND);
		}
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
