package com.aegon.survey.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.SurveyRepository;
import com.aegon.survey.demo.service.SurveyService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerSatisfactionSurveyApplicationTests {
	
	@Autowired
	private SurveyService surveyService;
	
	@MockBean
	private SurveyRepository surveyRepository;
	
	@Test
	public void getSurveysTest() {
		when(surveyRepository.findAll()).thenReturn(Stream
				.of(new Survey(1, "Groovy", 0), new Survey(2, "Uber", 0)).collect(Collectors.toList()));
		assertEquals(2, surveyService.getSurveys().size());
	}
	
	@Test
	public void saveSurveyTest() {
		Survey survey = new Survey(999, "Aegon", 99);
		when(surveyRepository.save(survey)).thenReturn(survey);
		assertEquals(survey, surveyService.saveSurvey(survey));
	}
}
