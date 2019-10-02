package HyperQuiz.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import HyperQuiz.entities.Answer;
import HyperQuiz.entities.Question;
import HyperQuiz.entities.Quiz;
import HyperQuiz.models.binding.QuestionDTO;
import HyperQuiz.models.service.AnswerServiceModel;
import HyperQuiz.models.service.QuestionServiceModel;
import HyperQuiz.models.service.QuizServiceModel;
import HyperQuiz.service.AnswerService;
import HyperQuiz.service.QuizService;

// TO DO Answer Service

@Component
public class QuestionMapper {
	
	@Autowired
	private QuizService quizService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private ModelMapper modelMapper;
	

	public Question mapQuestionDTOToQuestion(QuestionDTO questionDTO)  {
		Question question = new Question();
		question.setText(questionDTO.getText());

		Quiz quiz = quizService.findQuizByID(questionDTO.getQuizId());
		question.setQuiz(quiz);

		
		if (questionDTO.getAnswersIds() != null) {

			for (String answerId : questionDTO.getAnswersIds()) {
				Answer answer = answerService.findAnswerByID(answerId);
				question.getAnswers().add(answer);
			}
		}
		return question;
	}
}
