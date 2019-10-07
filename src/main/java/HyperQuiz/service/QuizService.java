package HyperQuiz.service;

import java.util.List;

import HyperQuiz.entities.Question;
import HyperQuiz.entities.Quiz;
import HyperQuiz.models.service.QuizServiceModel;

public interface QuizService {
	
	List<Quiz> findAllQuizzes();
	
	Quiz findQuizByID(String id);
	
	Quiz createQuiz(Quiz quiz);
	
	Quiz editQuiz(String id , Quiz quizServiceModel);
	
	void deleteQuiz(String id);

	List<Question> questionsForQuiz(Quiz quiz);
	 
	List<Question> randomQuestions(Quiz quiz, int numberOfQuestions);
	 
	

}
