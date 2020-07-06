package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;

@RequestMapping("/survey")
@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	//creates a survey.
	@PostMapping("/create")
	public Survey addSurvey(@RequestBody Survey survey) {
		return surveyService.saveSurvey(survey);
	}
	
	//lists Surveys
	@GetMapping("/list")
	public List<Survey> findAllSurveys() {
		surveyService.updateNpmScores();
		return surveyService.getSurveys();
	}
}
