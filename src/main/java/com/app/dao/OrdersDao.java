package com.app.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Orders;

public interface OrdersDao extends JpaRepository<Orders, Long>{
	List<Orders> findAllByOrderTimeGreaterThanAndOrderTimeLessThan(LocalDateTime start,LocalDateTime end);
}
