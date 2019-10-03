package HyperQuiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quiz_results")
public class QuizResult extends BaseEntity implements Comparable<QuizResult> {

	private Quiz quiz;
	private User user;
	private int score;
	
	public QuizResult() {}
	
	@ManyToOne(targetEntity = Quiz.class)
	@JoinColumn(
			name = "quiz_id",
			referencedColumnName = "id"
	)
	public Quiz getQuiz() {
		return quiz;
	}
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
	public User getUser() {
		return user;
	}

	public int getScore() {
		return score;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "score", nullable = false)
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(QuizResult quizResult) {
		return Integer.compare(this.score, quizResult.score);
	};
	
	
}
