package com.aegon.survey.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Topic;
import com.aegon.survey.demo.repository.TopicRepository;

import java.util.List;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;
	
	public Topic saveTopic(Topic topic) {
		return repository.save(topic);
	}
	
	public List<Topic> saveTopics(List<Topic> topics) {
		return repository.saveAll(topics);
	}
	
	public List<Topic> getTopics() {
		return repository.findAll();
	}
	
	public Topic getTopicById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Topic getTopicByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteTopic(int id) {
		repository.deleteById(id);
		return "Topic removed. "+id;
	}
	
	public Topic updateTopic(Topic topic) {
		Topic existingTopic=repository.findById(topic.getId()).orElse(null);
		existingTopic.setName(topic.getName());
		existingTopic.setNpmScore(topic.getNpmScore());
		return repository.save(existingTopic);
	}
	
}
