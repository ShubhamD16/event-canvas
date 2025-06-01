package com.app.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.app.dto.CreateOrder;
import com.app.dto.OrdersDto;


public interface OrdersService {
	List<OrdersDto> getAllOrders();
	List<OrdersDto> getAllOrdersForUser(Long UserId);
	OrdersDto addOrder(Long userId,CreateOrder order);
	List<OrdersDto> getAllOrdersBetweenDates(LocalDateTime start, LocalDateTime end);
}
