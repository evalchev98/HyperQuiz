package HyperQuiz.models.service;

import java.util.List;

import HyperQuiz.entities.Answer;
import HyperQuiz.entities.Quiz;

public class QuestionServiceModel extends BaseServiceModel {
	
	private String text;
	private List<Answer> answers;
	private Quiz quiz;
	
	public QuestionServiceModel() {
	}

	public String getText() {
		return text;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
}
