package HyperQuiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.QuizResult;
import HyperQuiz.repository.QuizResultRepository;

@Service
public class QuizResultServiceImpl implements QuizResultService{
	
	private QuizResultRepository quizResultRepository;
	
	@Autowired
	public QuizResultServiceImpl(QuizResultRepository quizResultRepository) {
		this.quizResultRepository = quizResultRepository;
	}

	@Override
	public QuizResult createQuizResult(QuizResult quizResult) {
		return this.quizResultRepository.save(quizResult);
	}

}
