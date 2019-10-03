package HyperQuiz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.Quiz;
import HyperQuiz.entities.QuizResult;
import HyperQuiz.repository.QuizResultRepository;

@Service
public class QuizResultServiceImpl implements QuizResultService{
	
	private QuizResultRepository quizResultRepository;
	private QuizService quizService;
	
	@Autowired
	public QuizResultServiceImpl(QuizResultRepository quizResultRepository,QuizService quizService) {
		this.quizResultRepository = quizResultRepository;
		this.quizService = quizService;
	}

	@Override
	public QuizResult createQuizResult(QuizResult quizResult) {
		return this.quizResultRepository.save(quizResult);
	}
	@Override
	public List<QuizResult> findAllQuizResults() {		
		return this.quizResultRepository.findAll();
	}
	
	@Override
	public List<QuizResult> findByQuiz(Quiz quiz) {
		List<QuizResult> quizResults = this.findAllQuizResults();
		List<QuizResult> quizResultsByQuiz=new ArrayList<QuizResult>();
		for (QuizResult tempQuizResult : quizResults) {
			if (tempQuizResult.getQuiz().equals(quiz)) {
				quizResultsByQuiz.add(tempQuizResult);
			}
		}
		return quizResultsByQuiz;
	}

	@Override
	public void sortResults(List<QuizResult> quizResults) {
		Collections.sort(quizResults);
		Collections.reverse(quizResults);
	}


}
