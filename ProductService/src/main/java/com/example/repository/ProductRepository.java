package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Product;

public interface ProductRepository extends MongoRepository<Product	, String>{

}
