package com.aegon.survey.demo.controller;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.service.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/survey")
@RestController
@CrossOrigin(origins = "*")
public class SurveyController {

	private final SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping
	public Survey addSurvey(@RequestBody Survey survey) {
		// TODO Convert Eklenecek
		return surveyService.saveSurvey(survey);

	}

	@GetMapping
	public List<Survey> findAllSurveys() {
		return surveyService.getSurveys();
	}
}
