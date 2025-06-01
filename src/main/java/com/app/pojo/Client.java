package com.app.pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

public class Client extends BaseEntity {

	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String email;
	private String phone;
	@Column(nullable = false)
	private String password;
	private String organization;
	private String userImage;
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	List<Orders> orders;
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private Feedback feedback;
	private LocalDateTime planActivationDate;
	private LocalDateTime durationOfPlan;
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Event> events;
	
}
