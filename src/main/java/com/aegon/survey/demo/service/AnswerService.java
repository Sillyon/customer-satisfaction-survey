package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.repository.AnswerRepository;
import com.aegon.survey.demo.repository.SurveyRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	// Create Submit (Fill Survey)
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	//List Answers By Topic
	public List<Answer> getAnswersByTopic(int topicId) {
		return answerRepository.findAllBySurveyTopicId(topicId);
	}
	
	// get all Survey Topics.
	public List<String> getTopics() {
		return surveyRepository.findAllTopics();
	}
}
