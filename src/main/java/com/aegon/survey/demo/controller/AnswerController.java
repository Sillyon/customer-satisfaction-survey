package com.aegon.survey.demo.controller;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/answer")
@RestController
@CrossOrigin(origins = "*")
public class AnswerController {

	private final AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	@GetMapping
	public List<Answer> findAllAnswers() {
		return answerService.getAnswers();
	}

	@GetMapping("/topic/{id}")
	public List<Answer> listAnswersByTopic(@PathVariable Long id) {
		return answerService.getAnswersByTopic(id);
	}

	@PostMapping
	public Answer addAnswer(@RequestBody Answer answer) {
		return answerService.saveAnswer(answer);
	}
}
