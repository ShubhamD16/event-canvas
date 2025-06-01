package com.app.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ClientDao;
import com.app.dao.OrdersDao;
import com.app.dao.SubscriptonDao;
import com.app.dto.CreateOrder;
import com.app.dto.OrdersDto;
import com.app.pojo.Client;
import com.app.pojo.Orders;
import com.app.pojo.Subscription;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	SubscriptonDao subDao;

	@Override
	public List<OrdersDto> getAllOrders() {
		return ordersDao.findAll().stream().map(o -> new OrdersDto(o)).collect(Collectors.toList());
	}

	@Override
	public List<OrdersDto> getAllOrdersBetweenDates(LocalDateTime start,LocalDateTime end) {
		return ordersDao.findAllByOrderTimeGreaterThanAndOrderTimeLessThan(start, end).stream()
				.map(o -> new OrdersDto(o)).collect(Collectors.toList());
	}
	
	@Override
	public OrdersDto addOrder(Long userId,CreateOrder createOrder) {
		System.out.println(createOrder);
		Client client = clientDao.findById(userId).orElse(null);
		if (client == null) {
			return null;
		}
		Subscription subscription = subDao.findById(createOrder.getSubscriptionId()).orElse(null);
		
		if (subscription == null) {
			return null;
		}
		
		Orders order = new Orders();
		order.setSubscription(subscription);
		order.setTransactionId("test123"); // Add transactionId from Razorpay
		order.setOrderTime(LocalDateTime.now());
		client.setDurationOfPlan(subscription.getDuration());
		client.setPlanActivationDate(LocalDateTime.now());
		order.setClient(client);
		// client.getOrders().add(order);
		return new OrdersDto(ordersDao.save(order));
	}

	@Override
	public List<OrdersDto> getAllOrdersForUser(Long UserId) {
		Client client = clientDao.findById(UserId).orElse(null);
		if (client == null) {
			return new ArrayList<OrdersDto>();
		}
		return client.getOrders().stream().map(o -> new OrdersDto(o)).collect(Collectors.toList());
	}
}
