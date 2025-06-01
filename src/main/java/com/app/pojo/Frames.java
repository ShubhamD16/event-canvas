package com.app.pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.pojo.AllEnums.FrameTypes;

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
public class Frames extends BaseEntity{
	private FrameTypes type;
	private String url;
	private String textData;
	// TODO Style new POCO to be created
	@ManyToOne
	@JoinColumn(name = "page_id")
	private Pages page;
}
