package com.app.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
public class Orders extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "client_id",nullable = false)
	Client client;
	@ManyToOne
	@JoinColumn(name = "subscription_id",nullable = false)
	Subscription subscription;
	LocalDateTime orderTime;
	String transactionId;
}
