package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository customerRepository;
	@Override
	@Transactional
	public User addCustomer(User Customer) {
		return customerRepository.save(Customer);
	}

	@Override
	@Transactional
	public String deleteCustomer(int CustomerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(CustomerId);
		return "xoa thanh cong id" + CustomerId;
	}

	@Override
	@Transactional
	public User updateCustomer(User Customer) {
		User Customer2 = customerRepository.saveAndFlush(Customer);
		return Customer2;
	}

	@Override
	@Transactional
	public User getCustomerById(int id) {
		User Customer = customerRepository.findById(id).get();
		return Customer;
	}

	@Override
	@Transactional
	public List<User> getListCustomer() {
		List<User> dsCustomer = customerRepository.findAll();
		return dsCustomer;
	}
}
