package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional //because NPSs of Topics are calculating before get Survey List.
	//List Survey object with Topics
	public List<Survey> getSurveys() {
		updateNpmScores();
		return surveyRepository.findAll();
	}
	
	public void updateNpmScores() {
		for (Survey survey : surveyRepository.findAll()) {
			List<Answer> answers = answerRepository.findAllBySurveyTopicId(survey.getTopicId());
			int promoterCount=0;
			int detractorCount=0;
			for (Answer answer : answers) {
				if(answer.getScore()>=9) {
					promoterCount++;
				}
				else if(answer.getScore()<=6) {
					detractorCount++;
				}
			}
			int answerCount = answers.size();
			int NPS=(100*(promoterCount-detractorCount))/answerCount;
			//update nps field
			Survey existingSurvey=surveyRepository.findById(survey.getTopicId()).orElse(null);
			existingSurvey.setNpmScore(NPS);
			surveyRepository.save(existingSurvey);
		}
	}
	
	// Create Multiple Surveys
	/*public List<Survey> saveSurveys(List<Survey> surveys) {
		return surveyRepository.saveAll(surveys);
	}*/
	
	// get survey object by id.
	/*public Survey getSurveyById(int id) {
		return surveyRepository.findById(id).orElse(null);
	}*/
	
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
}
