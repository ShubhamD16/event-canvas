package com.app.dto;

import java.time.LocalDateTime;

import com.app.pojo.Event;

import com.app.pojo.AllEnums.LoginType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
	private String name;
	private LocalDateTime start;
	private LocalDateTime end;
	private LoginType typeOfLogin;
	private String homePage;

	public EventDto(Event event) {
		if(event != null) {
			name = event.getName();
			start = event.getStart();
			end = event.getEnd();
			typeOfLogin = event.getTypeOfLogin();
			homePage = event.getHomePage();
		}
	}
}
