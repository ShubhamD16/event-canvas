package com.app.pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Pages extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	private String name;
	@OneToMany(mappedBy = "page",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Frames> frames;
}
