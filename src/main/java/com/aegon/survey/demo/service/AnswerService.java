package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository repository;
	
	public Answer saveAnswer(Answer answer) {
		return repository.save(answer);
	}
	
	public List<Answer> saveAnswers(List<Answer> answers) {
		return repository.saveAll(answers);
	}
	
	public List<Answer> getAnswers() {
		return repository.findAll();
	}
	/*
	public List<Answer> getAnswersByTopicId() {
		return repository.findAll();
	}
	
	//List Survey Answers
	public List<Answer> getAnswerBySurvey(int SurveyId) {
		return null;
	}*/
	
	public Answer getAnswerById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Answer updateAnswer(Answer answer) {
		Answer existingAnswer=repository.findById(answer.getSubmitId()).orElse(null);
		existingAnswer.setScore(answer.getScore());
		existingAnswer.setFeedback(answer.getFeedback());
		return repository.save(existingAnswer);
	}
}
