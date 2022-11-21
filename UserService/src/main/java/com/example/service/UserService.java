package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public interface UserService {
	public User addCustomer(User customer);

	public String deleteCustomer(int customerId);

	public User updateCustomer(User customer);

	public User getCustomerById(int id);

	public List<User> getListCustomer();
}
