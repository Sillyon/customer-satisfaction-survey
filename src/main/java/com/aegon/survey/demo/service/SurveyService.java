package com.aegon.survey.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.SurveyRepository;

import java.util.List;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository repository;
	
	public Survey saveSurvey(Survey survey) {
		return repository.save(survey);
	}
	
	public List<Survey> saveSurveys(List<Survey> surveys) {
		return repository.saveAll(surveys);
	}
	
	//List Survey topics
	public List<Survey> getSurveys() {
		return repository.findAll();
	}
	
	public void setNpmScore(int id) {
		
	}
	
	public Survey getSurveyById(int id) {
		//getnpmscorebyid
		return repository.findById(id).orElse(null);
	}
	
	public Survey getSurveyByTopic(String topic) {
		return repository.findByTopic(topic);
	}
	
	public Survey updateSurvey(Survey survey) {
		Survey existingSurvey=repository.findById(survey.getTopicId()).orElse(null);
		existingSurvey.setTopic(survey.getTopic());
		existingSurvey.setNpmScore(survey.getNpmScore());
		return repository.save(existingSurvey);
	}
}
