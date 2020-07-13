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
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	// Create Submit (Fill Survey)
	@Transactional //because there are 2 operations those they must be synchronized.
	public Answer saveAnswer(Answer answer) {
		List<Answer> answers = answerRepository.findAllBySurveyTopicId(answer.getSurvey().getTopicId());
		answers.add(answer);
		int answerCount = answers.size();
		if(answerCount!=0) {
			int promoterCount=0;
			int detractorCount=0;
			for (Answer anAnswer : answers) {
				if(anAnswer.getScore()>=9) {
					promoterCount++;
				}
				else if(anAnswer.getScore()<=6) {
					detractorCount++;
				}
			}
			int NPS=(int)(100*((float)(promoterCount-detractorCount)/answerCount));
			Survey survey = surveyRepository.findById(answer.getSurvey().getTopicId()).orElse(null);
			survey.setNpmScore(NPS);
			surveyRepository.save(survey);
		}
		return answerRepository.save(answer);
	}
	
	//List Answers By Topic
	public List<Answer> getAnswersByTopic(int topicId) {
		return answerRepository.findAllBySurveyTopicId(topicId);
	}
	
	//silinecek !!!!!!!!!!!!!!!!!!!!
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
}
