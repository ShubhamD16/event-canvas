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
public class FormAnswers extends BaseEntity{
	private String answer;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private FormQuestions question;
	private Long attendeeId;

}
