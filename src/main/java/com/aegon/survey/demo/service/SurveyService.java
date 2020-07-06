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
	
	//List Survey object with Topics
	public List<Survey> getSurveys() {
		return surveyRepository.findAll();
	}
	
	// this update method calling by listSurveys Rest
	public void updateNpmScores() {
		for (Survey survey : surveyRepository.findAll()) {
			List<Answer> answers = answerRepository.findAllBySurveyTopicId(survey.getTopicId());
			int answerCount = answers.size();
			if(answerCount!=0) {
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
				int NPS=(int)(100*((float)(promoterCount-detractorCount)/answerCount));
				survey.setNpmScore(NPS);
				surveyRepository.save(survey);
			}
		}
	}
	
	//returns topic string list from Survey table. 
	public List<String> getAllTopics() {
		return surveyRepository.findAllTopics();
	}
	
	// get survey object by id.
	public Survey getSurveyById(int id) {
		return surveyRepository.findById(id).orElse(null);
	}
}
