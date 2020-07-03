package com.aegon.survey.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Topics;
import com.aegon.survey.demo.service.TopicsService;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicsService service;
	
	public Topics addTopic() {
		return null;
	}
}
