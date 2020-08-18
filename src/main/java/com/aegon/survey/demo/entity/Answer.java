package com.aegon.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Answer extends AbstractEntity {

	private int score;
	private String feedback;

	@ManyToOne(targetEntity = Survey.class)
	private Survey survey;
}
