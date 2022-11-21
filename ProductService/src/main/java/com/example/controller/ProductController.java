package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductRepository productRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	@GetMapping("/{productId}")
	public Optional<Product> getProductById(@PathVariable int productId) {
		return productRepository.find(productId);
	}
	
}
