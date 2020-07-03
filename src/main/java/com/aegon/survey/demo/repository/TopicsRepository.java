package com.aegon.survey.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aegon.survey.demo.entity.Topics;

public interface TopicsRepository extends JpaRepository<Topics,Integer> {
	
	Topics findByName(String name);
	
}
