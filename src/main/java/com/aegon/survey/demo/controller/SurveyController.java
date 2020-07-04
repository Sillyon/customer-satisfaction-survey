package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;

@RequestMapping("/survey")
@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService service;
	
	@PostMapping("/createSurvey")
	public Survey addSurvey(@RequestBody Survey survey) {
		return service.saveSurvey(survey);
	}
	
	@GetMapping("/surveys")
	public List<Survey> findAllSurveys() {
		return service.getSurveys();
	}
	
	@GetMapping("/surveyById/{id}")
	public Survey findSurveyById(@PathVariable int id) {
		return service.getSurveyById(id);
	}
	
	@GetMapping("/surveyByTopic/{topic}")
	public Survey findSurveyByName(@PathVariable String topic) {
		return service.getSurveyByTopic(topic);
	}
	
	@PutMapping("/update")
	public Survey updateSurvey(@RequestBody Survey survey) {
		return service.saveSurvey(survey);
	}
}
