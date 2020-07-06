package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	//lists topics
	@GetMapping("/topics")
	public List<String> getTopics(){
		return answerService.getTopics();
	}
	
	//submits an answer.
	@PostMapping("/submit")
	public Answer addAnswer(@RequestBody Answer answer) {
		return answerService.saveAnswer(answer);
	}
	
	//lists answers of a Survey Topic.
	@GetMapping("/listByTopic/{topicId}")
	public List<Answer> listAnswersByTopic(@PathVariable int topicId) {
		return answerService.getAnswersByTopic(topicId);
	}
}
