package com.app.pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.app.pojo.AllEnums.LoginType;

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
public class Event extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	private String name;
	private LocalDateTime start;
	private LocalDateTime end;
	private LoginType typeOfLogin;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Gallary> gallary;
	private String homePage;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Pages> pages;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Attendees> attendees;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Forms> forms;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Polls> polls;
}
