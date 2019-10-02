package HyperQuiz.models.service;

import HyperQuiz.entities.Question;

public class AnswerServiceModel extends BaseServiceModel {

	private String text;
	private int score;
	private Question question;
	
	public AnswerServiceModel() {
	}

	public String getText() {
		return text;
	}

	public int getScore() {
		return score;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
