package com.aegon.survey.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Topics;
import com.aegon.survey.demo.repository.TopicsRepository;

import java.util.List;


@Service
public class TopicsService {
	
	@Autowired
	private TopicsRepository repository;
	
	public Topics saveTopic(Topics topic) {
		return repository.save(topic);
	}
	
	public List<Topics> saveTopics(List<Topics> topics) {
		return repository.saveAll(topics);
	}
	
	public List<Topics> getTopics() {
		return repository.findAll();
	}
	
	public Topics getTopicById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Topics getTopicByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteTopic(int id) {
		repository.deleteById(id);
		return "Topic removed. "+id;
	}
	
	public Topics updateTopic(Topics topic) {
		Topics existingTopic=repository.findById(topic.getId()).orElse(null);
		existingTopic.setName(topic.getName());
		existingTopic.setNpmScore(topic.getNpmScore());
		return repository.save(existingTopic);
	}
	
}
