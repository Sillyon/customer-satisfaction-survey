package com.aegon.survey.demo.repository;

import com.aegon.survey.demo.entity.Answer;
import com.aegon.survey.demo.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllBySurvey(Survey survey);

}
