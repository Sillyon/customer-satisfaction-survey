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

import com.aegon.survey.demo.entity.Topic;
import com.aegon.survey.demo.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService service;
	
	@PostMapping("/addTopic")
	public Topic addTopic(@RequestBody Topic topic) {
		return service.saveTopic(topic);
	}
	
	@PostMapping("/addTopics")
	public List<Topic> addTopics(@RequestBody List<Topic> topics) {
		return service.saveTopics(topics);
	}
	
	@GetMapping("/topics")
	public List<Topic> findAllTopics() {
		return service.getTopics();
	}
	
	@GetMapping("/topicById/{id}")
	public Topic findTopicById(@PathVariable int id) {
		return service.getTopicById(id);
	}
	
	@GetMapping("/topicByName/{name}")
	public Topic findTopicByName(@PathVariable String name) {
		return service.getTopicByName(name);
	}
	
	@PutMapping("/update")
	public Topic updateTopic(@RequestBody Topic topic) {
		return service.saveTopic(topic);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTopicById(@PathVariable int id) {
		return service.deleteTopic(id);
	}
}
