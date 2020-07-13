package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;

@RequestMapping("/survey")
@RestController
@CrossOrigin(origins = "*")
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
	public List<Survey> findAllSurveys() {
		return surveyService.getSurveys();
	}
}
