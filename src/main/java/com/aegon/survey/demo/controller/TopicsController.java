package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Topics;
import com.aegon.survey.demo.service.TopicsService;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicsService service;
	
	@PostMapping("/addtopic")
	public Topics addTopic(@RequestBody Topics topic) {
		return service.saveTopic(topic);
	}
	
	@PostMapping("/addtopics")
	public List<Topics> addTopics(@RequestBody List<Topics> topics) {
		return service.saveTopics(topics);
	}
	
	public List<Topics> findAllTopics(){
		return service.getTopics();
	}
	
	
	
}
