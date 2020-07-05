package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.AnswerRepository;
import com.aegon.survey.demo.repository.SurveyRepository;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	//Create Survey
	public Survey saveSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}
	
	// Create Multiple Surveys
	public List<Survey> saveSurveys(List<Survey> surveys) {
		return surveyRepository.saveAll(surveys);
	}
	
	public Survey getSurveyById(int id) {
		return surveyRepository.findById(id).orElse(null);
	}
	
	// ???
	public void setNpmScoresOfSurveys() {
		// TODO Auto-generated method stub
	}
	
	//returns topic string list from Survey table. 
	public List<String> getAllTopics() {
		return surveyRepository.findAllTopics();
		/*List<String> topicList = new ArrayList<String>();
		List<Survey> surveyList=getSurveys();
		for (Survey survey : surveyList) {
			topicList.add(survey.getTopic());
		}
		return topicList;*/
	}
	
	//List Survey object with Topics
	public List<Survey> getSurveys() {
		return surveyRepository.findAll();
	}
	
	//List Answers By Topic
	public List<Answer> getAnswersByTopic(int topicId) {
		return answerRepository.findAllBySurvey(topicId);
	}
}
