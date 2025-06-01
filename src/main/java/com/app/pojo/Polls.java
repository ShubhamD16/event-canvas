package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Polls extends BaseEntity{
	private String name;
	@OneToMany(mappedBy = "poll",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<PollQuestions> questions;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
}
