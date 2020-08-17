package com.aegon.survey.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Survey extends AbstractEntity {

    private String topic;
    private int npmScore;
}
