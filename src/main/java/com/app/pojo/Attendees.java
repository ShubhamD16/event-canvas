package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attendees extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	private String email;
	private String password;
}
