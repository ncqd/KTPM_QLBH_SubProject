package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderDTO;
import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Order2Controller {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Order addOrder(@RequestBody Order Order) {
		orderService.addOrder(Order);
		return Order;
	}
	@DeleteMapping("/{orderId}")
	public String deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
		return "xoá thành công id" + orderId;
	}
	@PostMapping("/update")
	public Order updateOrder(@RequestBody Order Order) {
		Order Order2 = orderService.updateOrder(Order);
		return Order2;
	}

	@GetMapping("/{id}")
	public OrderDTO getOrderById(@PathVariable int id) {
		OrderDTO Order = orderService.getOrderById(id);
		return Order;
	}

	@GetMapping
	public List<Order> getListOrder() {
		List<Order> dsOrder = orderService.getListOrder();
		return dsOrder;
	}
}
