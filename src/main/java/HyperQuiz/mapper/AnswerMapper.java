package HyperQuiz.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import HyperQuiz.entities.Answer;
import HyperQuiz.entities.Question;
import HyperQuiz.models.binding.AnswerDTO;
import HyperQuiz.models.service.AnswerServiceModel;
import HyperQuiz.models.service.QuestionServiceModel;
import HyperQuiz.service.AnswerService;
import HyperQuiz.service.QuestionService;



@Component
public class AnswerMapper {

	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionService questionService;
	@Autowired
	ModelMapper modelMapper;
	
	public Answer mapAnswerDTOToAnswer(AnswerDTO answerDTO) {
		Answer answer = new Answer();
		answer.setText(answerDTO.getText());
		
		Question question = questionService.findQuestionByID(answerDTO.getQuestionId());
		answer.setQuestion(question);

		
		answer.setScore(answerDTO.getScore());
		
		
		return answer;
	}
}
