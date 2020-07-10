package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	// Create Submit (Fill Survey)
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	//List Answers By Topic
	public List<Answer> getAnswersByTopic(int topicId) {
		return answerRepository.findAllBySurveyTopicId(topicId);
	}
	
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
	
	public Long count() {
		return answerRepository.count();
	}
}
