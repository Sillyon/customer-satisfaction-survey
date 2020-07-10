package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;


@RequestMapping("/survey")
@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	//creates a survey.
	@PostMapping
	public Survey addSurvey(@RequestBody Survey survey) throws Exception {
		if(survey.getNpmScore() != 0) {
			throw new Exception("You can't set NPS!");
		}
		else if(surveyService.isSurveyAlreadyExist(survey.getTopic()) == true) {
			throw new Exception("This survey already exists!");
		}
		else {
			return surveyService.saveSurvey(survey);
		}
	}
	
	//lists Surveys
	@GetMapping
	@Transactional //because there are to operations those they must be synchronized.
	public List<Survey> findAllSurveys() {
		surveyService.updateNpmScores();	// this is the updating NPS step.
		return surveyService.getSurveys();
	}
	
	@GetMapping("/{topicId}")
	public Survey getTopicById(@PathVariable int topicId) {
		return surveyService.getSurveyById(topicId);
	}
	
	//lists topics
	@GetMapping("/topics")
	public List<String> getTopics(){
		return surveyService.getAllTopics();
	}
	
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public Long count(){
    	return surveyService.count();
    }
}
