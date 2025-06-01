package com.app.dto;

import java.time.LocalDateTime;

import com.app.pojo.Subscription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_EMPTY)
public class CreateOrder {
	Long clientId;
	Long subscriptionId;
	LocalDateTime orderTime;
	String transactionId;
}
