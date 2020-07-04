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

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.service.AnswerService;

@RequestMapping("/answer")
@RestController
public class AnswerController {
	
	@Autowired
	private AnswerService service;
	
	@PostMapping("/answerSurvey")
	public Answer addAnswer(@RequestBody Answer answer) {
		return service.saveAnswer(answer);
	}
	
	@PostMapping("/answerSurveys")
	public List<Answer> addAnswers(@RequestBody List<Answer> answers) {
		return service.saveAnswers(answers);
	}
	
	@GetMapping("/answers")
	public List<Answer> findAllAnswers() {
		return service.getAnswers();
	}
	
	@GetMapping("/answerById/{id}")
	public Answer findAnswerById(@PathVariable int id) {
		return service.getAnswerById(id);
	}
	
	@PutMapping("/update")
	public Answer updateAnswer(@RequestBody Answer answer) {
		return service.saveAnswer(answer);
	}
}
