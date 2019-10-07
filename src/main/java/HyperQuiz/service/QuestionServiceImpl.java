package HyperQuiz.service;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.Question;
import HyperQuiz.mapper.QuestionMapper;
import HyperQuiz.models.binding.QuestionDTO;
import HyperQuiz.models.service.QuestionServiceModel;
import HyperQuiz.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService	 {
	
	@Autowired
	private QuestionRepository questionRepository;
	//private ModelMapper modelMapper;
	@Autowired
	private QuestionMapper questionMapper;
	
	/*
	 * @Autowired public QuestionServiceImpl(QuestionRepository questionRepository ,
	 * QuestionMapper questionMapper) { this.questionRepository =
	 * questionRepository; //this.modelMapper = modelMapper; this.questionMapper =
	 * questionMapper; }
	 */

	@Override
	public Question createQuestion(QuestionDTO questionDTO) {
		Question question = questionMapper.mapQuestionDTOToQuestion(questionDTO);		
		return this.questionRepository.save(question);

	}

	@Override
	public List<Question> findAllQuestions() {
		return this.questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(String id) {
		Question question = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		this.questionRepository.delete(question);
	}

	@Override
	public Question findQuestionByID(String id) {
		return this.questionRepository.findById(id).orElseThrow(()-> new IllegalArgumentException() );
	}	

}
