package com.aegon.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Survey extends AbstractEntity {

	private String topic;

	@Enumerated(EnumType.STRING)
	private QuestionType type;

	private int npmScore;

	// TODO düzenlenecek.
	public void setNpmScore(int npmScore) {
		return;
	}
}
