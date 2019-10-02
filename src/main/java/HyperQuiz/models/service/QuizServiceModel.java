package HyperQuiz.models.service;

import java.util.List;

import HyperQuiz.entities.Question;

public class QuizServiceModel extends BaseServiceModel {
	
	private String name;
	private int expectedDuration;
	private List<Question> questions;
	
	public QuizServiceModel() {
	}

	public String getName() {
		return name;
	}

	public int getExpectedDuration() {
		return expectedDuration;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExpectedDuration(int expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	

}
