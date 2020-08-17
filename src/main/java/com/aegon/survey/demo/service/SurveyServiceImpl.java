package com.aegon.survey.demo.service;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.SurveyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean isSurveyAlreadyExist(String topic) {
        return surveyRepository.existsByTopic(topic);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Survey saveSurvey(Survey survey) {
        if (survey.getNpmScore() != 0) {
            throw new RuntimeException("You can't set NPS!");
        } else if (isSurveyAlreadyExist(survey.getTopic())) {
            throw new RuntimeException("This survey already exists!");
        }
        return surveyRepository.save(survey);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Survey getSurveyById(Long topicId) {
        return surveyRepository.findById(topicId).orElse(null);
    }
}
