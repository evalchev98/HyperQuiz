package HyperQuiz.models.binding;

import org.springframework.stereotype.Component;


public class QuestionDTO {
	private String id;
	private String quizId;
	private String text;
	private String[] answersIds;
	
	public String getQuizId() {
		return quizId;
	}
	public String getText() {
		return text;
	}

	public String[] getAnswersIds() {
		return answersIds;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setAnswersIds(String[] answersIds) {
		this.answersIds = answersIds;
	}
	
	
}
