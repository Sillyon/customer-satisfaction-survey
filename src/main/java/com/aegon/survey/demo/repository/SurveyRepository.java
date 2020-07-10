package com.aegon.survey.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.aegon.survey.demo.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {
	
	Boolean existsByTopic(String topic);
	
	@Query("select topic FROM Survey")
	List<String> findAllTopics();

}
