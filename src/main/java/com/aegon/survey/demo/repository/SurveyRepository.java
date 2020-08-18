package com.aegon.survey.demo.repository;

import com.aegon.survey.demo.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

	Boolean existsByTopic(String topic);

}
