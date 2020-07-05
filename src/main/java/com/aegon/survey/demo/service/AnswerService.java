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
	
	// multiple submits.
	public List<Answer> saveAnswers(List<Answer> answers) {
		return answerRepository.saveAll(answers);
	}
	
	// get All Answers.
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
	
	//List Survey Answers
	public List<Answer> getAnswerBySurvey(int topicId) {
		return null;
	}
	
	public Answer updateAnswer(Answer answer) {
		Answer existingAnswer=answerRepository.findById(answer.getSubmitId()).orElse(null);
		existingAnswer.setScore(answer.getScore());
		existingAnswer.setFeedback(answer.getFeedback());
		return answerRepository.save(existingAnswer);
	}
	
	// 
	public List<String> getTopics() {
		return surveyRepository.findAllTopics();
	}
}
