package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Subscription;

public interface SubscriptonDao extends JpaRepository<Subscription, Long> {

}
