package com.app.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

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

public class Subscription extends BaseEntity{
private	String name;
private int price;
private LocalDateTime duration;
private double discount;
@Column(length = 6400)
private String description;
private boolean isActive;
}
