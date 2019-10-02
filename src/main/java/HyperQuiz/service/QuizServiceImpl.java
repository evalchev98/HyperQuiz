package HyperQuiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.Quiz;
import HyperQuiz.exception.QuizNameExistsException;
import HyperQuiz.models.service.QuizServiceModel;
import HyperQuiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {
	
	private final QuizRepository quizRepository;
//	private final ModelMapper modelMapper;
	
	
	@Autowired
	public QuizServiceImpl(QuizRepository quizRepository  ) {
		this.quizRepository = quizRepository;
	//	this.modelMapper = modelMapper;
	}


	@Override
	public List<Quiz> findAllQuizzes() {
		return this.quizRepository.findAll();
	}
	
	@Override
	public Quiz findQuizByID(String id) {
		return this.quizRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}


	@Override
	public Quiz createQuiz(Quiz quiz)  {
		
		return this.quizRepository.save(quiz);
	}


	@Override
	public Quiz editQuiz(String id, Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteQuiz(String id) {
		Quiz quiz= quizRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
		this.quizRepository.delete(quiz);
	}

	
}
