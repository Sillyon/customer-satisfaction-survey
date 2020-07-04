package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Topics;
import com.aegon.survey.demo.service.TopicsService;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicsService service;
	
	@PostMapping("/addTopic")
	public Topics addTopic(@RequestBody Topics topic) {
		return service.saveTopic(topic);
	}
	
	@PostMapping("/addTopics")
	public List<Topics> addTopics(@RequestBody List<Topics> topics) {
		return service.saveTopics(topics);
	}
	
	@GetMapping("/topics")
	public List<Topics> findAllTopics() {
		return service.getTopics();
	}
	
	@GetMapping("/topicById/{id}")
	public Topics findTopicById(@PathVariable int id) {
		return service.getTopicById(id);
	}
	
	@GetMapping("/topicByName/{name}")
	public Topics findTopicByName(@PathVariable String name) {
		return service.getTopicByName(name);
	}
	
	@PutMapping("/update")
	public Topics updateTopic(@RequestBody Topics topic) {
		return service.saveTopic(topic);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTopicById(@PathVariable int id) {
		return service.deleteTopic(id);
	}
}
