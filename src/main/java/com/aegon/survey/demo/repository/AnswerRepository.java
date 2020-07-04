package com.aegon.survey.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegon.survey.demo.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	Answer findByName(String name);

}
