package HyperQuiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.Answer;
import HyperQuiz.mapper.AnswerMapper;
import HyperQuiz.models.binding.AnswerDTO;
import HyperQuiz.models.service.AnswerServiceModel;
import HyperQuiz.models.service.QuestionServiceModel;
import HyperQuiz.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	AnswerRepository answerRepository;
	//ModelMapper modelMapper;
	AnswerMapper answerMapper;
	
	
	@Autowired
	public AnswerServiceImpl(AnswerRepository answerRepository , AnswerMapper answerMapper) {
		this.answerRepository = answerRepository;
		//this.modelMapper = modelMapper;
		this.answerMapper = answerMapper;
	}

	@Override
	public Answer createAnswer(AnswerDTO answerDTO) {
		Answer answer = this.answerMapper.mapAnswerDTOToAnswer(answerDTO);
		return this.answerRepository.save(answer);
	}

	@Override
	public List<Answer> findAllAnswers() {
		return this.answerRepository.findAll();
	}

	@Override
	public void deleteAnswer(String id) {
		Answer answer = this.answerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		this.answerRepository.delete(answer);
	}

	@Override
	public Answer findAnswerByID(String id) {
		return this.answerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

}
