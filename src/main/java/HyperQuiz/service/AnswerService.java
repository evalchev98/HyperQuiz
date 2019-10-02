package HyperQuiz.service;

import java.util.List;

import HyperQuiz.entities.Answer;
import HyperQuiz.models.binding.AnswerDTO;
import HyperQuiz.models.service.AnswerServiceModel;


public interface AnswerService {
	
	Answer createAnswer(AnswerDTO answerDTO);
	
	List<Answer> findAllAnswers();
	
	void deleteAnswer(String id);
	
	Answer findAnswerByID(String id);
}
