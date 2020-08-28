package com.aegon.survey.demo.service;

import com.aegon.survey.demo.entity.Survey;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface SurveyService {

	Boolean isSurveyAlreadyExist(String topic);

	Survey saveSurvey(Survey survey);

	List<Survey> getSurveys();

	ResponseEntity<Survey> getSurveyById(Long topicId);
}
