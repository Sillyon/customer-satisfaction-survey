package com.aegon.survey.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegon.survey.demo.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer> {
	
	Topic findByName(String name);
	
}
