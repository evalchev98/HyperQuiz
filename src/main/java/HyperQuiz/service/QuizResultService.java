package HyperQuiz.service;

import java.util.List;

import HyperQuiz.entities.Quiz;
import HyperQuiz.entities.QuizResult;

public interface QuizResultService {

	QuizResult createQuizResult(QuizResult quizResult);
	List<QuizResult> findAllQuizResults();
	List<QuizResult> findByQuiz(Quiz quiz);
	void sortResults(List<QuizResult> quizResults);
}
