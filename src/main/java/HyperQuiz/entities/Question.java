package HyperQuiz.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="questions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question extends BaseEntity {
	private String text;
	private List<Answer> answers;
	private Quiz quiz;
	
	
	public Question() {
	}

	@Column(name = "question_text", nullable = true, unique = false, updatable = true)
	public String getText() {
		return text;
	}
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@JoinColumn
	@ManyToOne
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
	

}
