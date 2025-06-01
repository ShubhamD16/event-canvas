package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class PollQuestions extends BaseEntity{
	private String question;
	@ManyToOne
	@JoinColumn(name = "poll_id")
	private Polls poll;
	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL,orphanRemoval = true)
	List<PollOptions> options;
	
}
