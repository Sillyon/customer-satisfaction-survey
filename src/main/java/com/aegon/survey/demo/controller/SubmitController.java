package com.aegon.survey.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.survey.demo.entity.Submit;
import com.aegon.survey.demo.service.SubmitService;

@RequestMapping("/submit")
@RestController
public class SubmitController {
	
	@Autowired
	private SubmitService service;
	
	@PostMapping("/addSubmit")
	public Submit addSubmit(@RequestBody Submit submit) {
		return service.saveSubmit(submit);
	}
	
	@PostMapping("/addSubmits")
	public List<Submit> addSubmits(@RequestBody List<Submit> submits) {
		return service.saveSubmits(submits);
	}
	
	@GetMapping("/submits")
	public List<Submit> findAllSubmits() {
		return service.getSubmits();
	}
	
	@GetMapping("/submitById/{id}")
	public Submit findSubmitById(@PathVariable int id) {
		return service.getSubmitById(id);
	}
	
	@PutMapping("/update")
	public Submit updateSubmit(@RequestBody Submit submit) {
		return service.saveSubmit(submit);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSubmitById(@PathVariable int id) {
		return service.deleteSubmit(id);
	}
}
