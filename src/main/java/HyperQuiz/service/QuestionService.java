package HyperQuiz.service;

import java.util.List;

import HyperQuiz.entities.Question;
import HyperQuiz.models.binding.QuestionDTO;

public interface QuestionService {
	
	Question createQuestion(QuestionDTO questionDTO);
	
	List<Question> findAllQuestions();
	
	void deleteQuestion(String id);
	
	Question findQuestionByID(String id);

}
