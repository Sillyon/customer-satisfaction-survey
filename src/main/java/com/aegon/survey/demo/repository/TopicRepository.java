package com.aegon.survey.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aegon.survey.demo.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic,Integer> {
	
	Topic findByName(String name);
	
}
