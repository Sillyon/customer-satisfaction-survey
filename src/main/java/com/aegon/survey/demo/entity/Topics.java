package com.aegon.survey.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topics {
	
    @Id
    @GeneratedValue
    private int id;
	private String name;
	private byte npmScore;
}
