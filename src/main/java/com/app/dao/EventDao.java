package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Event;

public interface EventDao extends JpaRepository<Event, Long> {
}
