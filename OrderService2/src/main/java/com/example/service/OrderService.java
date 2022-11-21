package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.OrderDTO;
import com.example.dto.OrderDTORefProductDTO;
import com.example.dto.OrderRefAll;
import com.example.dto.ProductDTO;
import com.example.entity.Order;

@Service
public interface OrderService {
	public Order addOrder(Order order);

	public String deleteOrder(int orderId);

	public Order updateOrder(Order order);

	public OrderDTO getOrderById(int id);
	
	public ProductDTO getProductById(int id);
	
	public OrderDTORefProductDTO getOrderByIdProduct(int id);
	
	public OrderRefAll getOrderByIdGetAll(int id) ;

	public List<Order> getListOrder();
}
