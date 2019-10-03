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
	private String imageUrl;
	
    @Column(name = "image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + expectedDuration;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (expectedDuration != other.expectedDuration)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}
	
	
	
}
