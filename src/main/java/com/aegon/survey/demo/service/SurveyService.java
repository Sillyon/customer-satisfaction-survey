package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.SurveyRepository;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	public Boolean isSurveyAlreadyExist(String topic) {
		return surveyRepository.existsByTopic(topic);
	}
	
	//Create Survey
	public Survey saveSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}
	
	//List Survey object with Topics
	public List<Survey> getSurveys() {
		List<Survey> surveys = surveyRepository.findAll();
		return surveys;
	}
	
	// get survey object by id.
	public Survey getSurveyById(int topicId) {
		return surveyRepository.findById(topicId).orElse(null);
	}
}
