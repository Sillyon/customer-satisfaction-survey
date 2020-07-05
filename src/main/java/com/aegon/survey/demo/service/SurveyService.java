package com.aegon.survey.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.AnswerRepository;
import com.aegon.survey.demo.repository.SurveyRepository;

import java.util.List;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public Survey saveSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}
	
	public List<Survey> saveSurveys(List<Survey> surveys) {
		return surveyRepository.saveAll(surveys);
	}
	
	//List Survey topics
	public List<Survey> getSurveys() {
		return surveyRepository.findAll();
	}
	
	public Survey getSurveyById(int id) {
		return surveyRepository.findById(id).orElse(null);
	}

	public void setNpmScoresOfSurveys() {
		// TODO Auto-generated method stub
	}
	
	//returns topic string list from Survey table. 
	public List<String> getTopics() {
		return surveyRepository.findAllTopics();
		/*List<String> topicList = new ArrayList<String>();
		List<Survey> surveyList=getSurveys();
		for (Survey survey : surveyList) {
			topicList.add(survey.getTopic());
		}
		return topicList;*/
	}
	
	public List<Answer> getAnswersByTopic(int topicId) {
		return answerRepository.findAllBySurvey(topicId);
	}
}
