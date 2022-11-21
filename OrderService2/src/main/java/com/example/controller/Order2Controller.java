package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderDTO;
import com.example.dto.OrderDTORefProductDTO;
import com.example.dto.OrderRefAll;
import com.example.entity.Order;
import com.example.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/order")
//@EnableCircuitBreaker
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Order2Controller {
	@Autowired
	private OrderService orderService;
	

	public static final String Service_Order = "serviceOrder";
	
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

	int count = 1;
//	@Retry(name = ServiceUser)
//	@RateLimiter(name = ServiceUser)
	@GetMapping("/{id}")
	@CircuitBreaker(name = Service_Order, fallbackMethod = "ServiceOrderFallBack")
	public OrderDTO getOrderById(@PathVariable int id) {
		System.out.println("retry " + count++ + new Date());
		OrderDTO Order = orderService.getOrderById(id);
		return Order;
	}
	@GetMapping("/product/{id}")
//	@CircuitBreaker(name = Service_Order, fallbackMethod = "ServiceOrderFallBack")
	public OrderDTORefProductDTO getOrderByProductId(@PathVariable int id) {
//		System.out.println("retry " + count++ + new Date());
		OrderDTORefProductDTO Order = orderService.getOrderByIdProduct(id);
		return Order;
	}
	
	public OrderDTO  ServiceOrderFallBack(Exception e) {
		OrderDTO order = null;
		System.out.println("Have Error");
		return order;
	}
	@GetMapping("/all/{id}")
	public OrderRefAll getOrderAll(@PathVariable int id) {
//		System.out.println("retry " + count++ + new Date());
		OrderRefAll Order = orderService.getOrderByIdGetAll(id);
		return Order;
	}

	@GetMapping
	public List<Order> getListOrder() {
		List<Order> dsOrder = orderService.getListOrder();
		return dsOrder;
	}
}
