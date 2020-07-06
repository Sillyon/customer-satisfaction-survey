package com.aegon.survey.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Survey {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int topicId;
    
	private String topic;
	
	//private String question; //idk should i store question.
	
	private int npmScore;
}
