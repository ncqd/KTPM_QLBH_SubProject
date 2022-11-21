package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/user")
@EnableCaching
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService customerService;
	
	@PostMapping
	public User addCustomer(@RequestBody User customer) {
		customerService.addCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{userId}")
	@CacheEvict(value = "user", key = "#userId")
	public String deleteCustomer(@PathVariable int userId) {
		customerService.deleteCustomer(userId);
		return "xoá thành công id" + userId;
	}

	@PostMapping("/update")
//	@CachePut(value = "users", key = "#user.userId")
	public User updateCustomer(@RequestBody User customer) {
		User customer2 = customerService.updateCustomer(customer);
		return customer2;
	}

	@GetMapping("/{userId}")
	@Cacheable(value = "user", key = "#userId")
	public User getCustomerById(@PathVariable int userId) {
		User customer = customerService.getCustomerById(userId);
		return customer;
	}

	@GetMapping
	public List<User> getListCustomer() {
		List<User> dsCustomer = customerService.getListCustomer();
		return dsCustomer;
	}
}
