package com.aegon.survey.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegon.survey.demo.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Integer> {

	Survey findByTopic(String name);
	
}
