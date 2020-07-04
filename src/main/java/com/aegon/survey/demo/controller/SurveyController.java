package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;

import io.swagger.annotations.Api;

@RequestMapping("/survey")
@RestController
@Api(value="survey", description=" Survey Operations Service")
public class SurveyController {
	
	@Autowired
	private SurveyService service;
	
	@PostMapping("/addSurvey")
	public Survey addSurvey(@RequestBody Survey survey) {
		return service.saveSurvey(survey);
	}
	
	@PostMapping("/addSurveys")
	public List<Survey> addSurveys(@RequestBody List<Survey> surveys) {
		return service.saveSurveys(surveys);
	}
	
	@GetMapping("/surveys")
	public List<Survey> findAllSurveys() {
		return service.getSurveys();
	}
	
	@GetMapping("/surveyById/{id}")
	public Survey findSurveyById(@PathVariable int id) {
		return service.getSurveyById(id);
	}
	
	@GetMapping("/surveyByName/{name}")
	public Survey findSurveyByName(@PathVariable String name) {
		return service.getSurveyByName(name);
	}
	
	@PutMapping("/update")
	public Survey updateSurvey(@RequestBody Survey survey) {
		return service.saveSurvey(survey);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSurveyById(@PathVariable int id) {
		return service.deleteSurvey(id);
	}
}
