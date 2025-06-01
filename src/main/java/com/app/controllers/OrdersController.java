package com.app.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CreateOrder;
import com.app.dto.OrdersDto;
import com.app.services.OrdersServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrdersController{
	
	@Autowired
	OrdersServiceImpl ordersService;

	@GetMapping("/all")
	public List<OrdersDto> getAllOrders() {
		return ordersService.getAllOrders();
	}
	
	@GetMapping("/{userId}")
	public List<OrdersDto> getAllOrdersForUser(@PathVariable Long userId){
		return ordersService.getAllOrdersForUser(userId);
	}
	
	@GetMapping("/between")
	public List<OrdersDto> getAllOrdersBetweenDates(@RequestParam("start") LocalDateTime start,@RequestParam("end") LocalDateTime end) {
		return ordersService.getAllOrdersBetweenDates(start, end);
	}
	
	@PostMapping("/create/{userId}")
	public OrdersDto CreateOrder(@PathVariable Long userId,@RequestBody CreateOrder createOrder) {
		
		return ordersService.addOrder(userId,createOrder);
	}
}
