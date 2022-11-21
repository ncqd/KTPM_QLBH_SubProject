package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.Product;

public interface ProductRepository extends MongoRepository<Product	, String>{
	@Query("{productId: ?0}")
	Optional<Product> find(int productId);
}
