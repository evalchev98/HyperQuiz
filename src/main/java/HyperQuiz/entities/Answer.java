package HyperQuiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="answers")
public class Answer extends BaseEntity {
	private String text;
	private int score;
	private Question question;
	
	@JoinColumn
	@ManyToOne
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer() {
	}
	
	@Column(name = "answer_text", nullable = false, unique = false, updatable = true)
	public String getText() {
		return text;
	}
	
	@Column(name = "answer_score", nullable = false, unique = false, updatable = true)
	public int getScore() {
		return score;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
