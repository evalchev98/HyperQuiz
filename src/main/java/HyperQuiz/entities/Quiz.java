package HyperQuiz.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="quizzes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz extends BaseEntity  {
	
	private String name;
	private int expectedDuration;
	private List<Question> questions;
	
	public Quiz() {
	}

	public String getName() {
		return name;
	}

	public int getExpectedDuration() {
		return expectedDuration;
	}
	
	@Column(name = "quiz_name", nullable = false, unique = true, updatable = true)
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "quiz_expectedDuration", nullable = false, unique = false, updatable = true)
	public void setExpectedDuration(int expectedDuration) {
		this.expectedDuration = expectedDuration;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
}
