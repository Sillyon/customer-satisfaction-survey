package com.aegon.survey.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.survey.demo.entity.Submit;
import com.aegon.survey.demo.repository.SubmitRepository;

@Service
public class SubmitService {
	
	@Autowired
	private SubmitRepository repository;
	
	public Submit saveSubmit(Submit submit) {
		return repository.save(submit);
	}
	
	public List<Submit> saveSubmits(List<Submit> submits) {
		return repository.saveAll(submits);
	}
	
	public List<Submit> getSubmits() {
		return repository.findAll();
	}
	
	public Submit getSubmitById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteSubmit(int id) {
		repository.deleteById(id);
		return "Submit removed. "+id;
	}
	
	public Submit updateSubmit(Submit submit) {
		Submit existingSubmit=repository.findById(submit.getSubmitId()).orElse(null);
		existingSubmit.setScore(submit.getScore());
		existingSubmit.setFeedback(submit.getFeedback());
		return repository.save(existingSubmit);
	}
}
