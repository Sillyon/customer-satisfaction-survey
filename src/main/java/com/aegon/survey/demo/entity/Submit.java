package com.aegon.survey.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int submitId;
	
	private int score;
	
	private String feedback;
	
	@ManyToOne
	@JoinColumn(name ="topicId")
	private Topic topic;
}
