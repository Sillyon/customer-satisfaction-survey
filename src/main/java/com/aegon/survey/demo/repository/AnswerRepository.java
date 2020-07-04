package com.aegon.survey.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aegon.survey.demo.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	Answer findByName(String name);

}
