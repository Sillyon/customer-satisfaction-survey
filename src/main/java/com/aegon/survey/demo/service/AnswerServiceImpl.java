package com.aegon.survey.demo.service;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.AnswerRepository;
import com.aegon.survey.demo.repository.SurveyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

	private final AnswerRepository answerRepository;

	private final SurveyRepository surveyRepository;

	public AnswerServiceImpl(AnswerRepository answerRepository, SurveyRepository surveyRepository) {
		this.answerRepository = answerRepository;
		this.surveyRepository = surveyRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Answer saveAnswer(Answer answer) {
		Survey survey = answer.getSurvey();
		if (survey == null || survey.getId() == null || survey.getId() == 0) {
			throw new RuntimeException("Answer has no assign by any Survey Topic!");
		} else if (answer.getScore() < 0 || answer.getScore() > 10) {
			throw new RuntimeException("Score is invalid!");
		}

		survey = surveyRepository.getOne(survey.getId());

		List<Answer> answers = answerRepository.findAllBySurveyId(survey.getId());
		answers.add(answer);
		int answerCount = answers.size();
		if (answerCount != 0) {
			int promoterCount = 0;
			int detractorCount = 0;
			for (Answer anAnswer : answers) {
				if (anAnswer.getScore() >= 9) {
					promoterCount++;
				} else if (anAnswer.getScore() <= 6) {
					detractorCount++;
				}
			}
			int npmScore = (int) (100 * ((float) (promoterCount - detractorCount) / answerCount));
			survey.setNpmScore(npmScore);
			surveyRepository.save(survey);
		}
		return answerRepository.save(answer);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Answer> getAnswersByTopic(Long topicId) {
		return answerRepository.findAllBySurveyId(topicId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
}
