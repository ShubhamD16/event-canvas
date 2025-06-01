package com.app.services;

import com.app.dto.EventDto;
import com.app.pojo.Event;

public interface EventService {
	Long GetAllEventCount();
	EventDto createEvent(Long userId,Event event);
	EventDto editEvent(Long eventId,Event event);
	String deleteEvent(Long eventId);
}
