package HyperQuiz.models.binding;

import org.springframework.stereotype.Component;


public class AnswerDTO {
	private String id;
	private String questionId;
	private String text;
	private int score;

	public String getQuestionId() {
		return questionId;
	}

	public String getText() {
		return text;
	}

	public int getScore() {
		return score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
