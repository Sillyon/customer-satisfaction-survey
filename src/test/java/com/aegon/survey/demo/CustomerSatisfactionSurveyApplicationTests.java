package com.aegon.survey.demo;

import com.aegon.survey.demo.entity.Survey;
import com.aegon.survey.demo.repository.SurveyRepository;
import com.aegon.survey.demo.service.SurveyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerSatisfactionSurveyApplicationTests {

	@InjectMocks
	private SurveyServiceImpl surveyService;

	@Mock
	private SurveyRepository surveyRepository;

	@Test
	public void getSurveysTest() {
		Survey survey = new Survey();
		survey.setId(1L);
		survey.setTopic("Groovy");
		survey.setNpmScore(0);

		Survey survey2 = new Survey();
		survey.setId(2L);
		survey.setTopic("Uber");
		survey.setNpmScore(0);

		when(surveyRepository.findAll()).thenReturn(Stream.of(survey, survey2).collect(Collectors.toList()));

		List<Survey> foundSurvey = surveyService.getSurveys();

		assertNotNull(foundSurvey);
		assertEquals(2, foundSurvey.size());

		verify(surveyRepository).findAll();
	}

	@Test
	public void saveSurveyTest() {
		Survey survey = new Survey();
		survey.setTopic("Aegon");
		survey.setNpmScore(0);

		when(surveyRepository.save(survey)).thenReturn(survey);
		assertEquals(survey, surveyService.saveSurvey(survey));
	}
}
