package HyperQuiz.models.view;

public class QuizViewModel {
	String id;
	String text;
	int expectedDuration;

	public QuizViewModel() {
	}

	public String getText() {
		return text;
	}

	public int getExpectedDuration() {
		return expectedDuration;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setExpectedDuration(int expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
