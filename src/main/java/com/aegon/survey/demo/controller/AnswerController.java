package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.service.AnswerService;

@RequestMapping("/answer")
@RestController
@CrossOrigin(origins = "*")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	//silinecek!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@GetMapping
	public List<Answer> findAllAnswers() {
		return answerService.getAnswers();
	}
	
	//lists answers of a Survey Topic.
    @GetMapping("/topic/{topicId}")
	public List<Answer> listAnswersByTopic(@PathVariable int topicId) {
		return answerService.getAnswersByTopic(topicId);
	}
    
	//adds an answer.
	@PostMapping
	public Answer addAnswer(@RequestBody Answer answer) throws Exception {
		if(answer.getSurvey().getTopicId()==0) {
			throw new Exception("Answer has no assign by any Survey Topic!");
		}
		else if(answer.getScore()<0 || answer.getScore()>10) {
			throw new Exception("Score is invalid!");
		}
		else {
			return answerService.saveAnswer(answer);
		}
	}
}
