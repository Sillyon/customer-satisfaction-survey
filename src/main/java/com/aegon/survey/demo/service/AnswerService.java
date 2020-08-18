package com.aegon.survey.demo.service;

import com.aegon.survey.demo.entity.Answer;

import java.util.List;

public interface AnswerService {

	Answer saveAnswer(Answer answer);

	List<Answer> getAnswersByTopic(Long topicId);

	List<Answer> getAnswers();
}
