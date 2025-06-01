package com.app.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.app.pojo.Client;
import com.app.pojo.Feedback;
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
public class FeedbackDto {
	private String feedback;
	private LocalDateTime date;
	private ClientDto client;

	public FeedbackDto(Feedback fback) {
		if (fback != null) {
			feedback = fback.getFeedback();
			date = fback.getDate();
			client = new ClientDto(fback.getClient());
		}
	}
}
