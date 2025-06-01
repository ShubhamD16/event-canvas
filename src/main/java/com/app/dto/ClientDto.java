package com.app.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.app.pojo.Client;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class ClientDto {
	private Long id;
	private String userName;
	private String email;
	private String phone;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String organization;
	private String userImage;
	private LocalDateTime planActivationDate;
	private LocalDateTime durationOfPlan;

	public ClientDto(Client client) {
		if (client != null) {
			id = client.getId();
			userName = client.getUserName();
			email = client.getEmail();
			phone = client.getPhone();
			password = client.getPassword();
			organization = client.getOrganization();
			userImage = client.getUserImage();
			planActivationDate = client.getPlanActivationDate();
			durationOfPlan = client.getDurationOfPlan();
		}
	}
}
