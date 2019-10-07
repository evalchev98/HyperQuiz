package HyperQuiz.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HyperQuiz.entities.Question;
import HyperQuiz.entities.Quiz;
import HyperQuiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private QuestionService questionSerivce;

	/*
	 * @Autowired public QuizServiceImpl(QuizRepository
	 * quizRepository,QuestionService questionService) { this.quizRepository =
	 * quizRepository; this.questionSerivce = questionService; }
	 */

	@Override
	public List<Quiz> findAllQuizzes() {
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz findQuizByID(String id) {
		return this.quizRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Quiz createQuiz(Quiz quiz) {

		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz editQuiz(String id, Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuiz(String id) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		this.quizRepository.delete(quiz);
	}

	@Override
	public List<Question> questionsForQuiz(Quiz quiz) {
		List<Question> allQuestions = this.questionSerivce.findAllQuestions();
		List<Question> questionsForQuiz = new ArrayList<Question>();
		for (Question question : allQuestions) {
			if (question.getQuiz().equals(quiz)) {
				questionsForQuiz.add(question);
			}
		}
		return questionsForQuiz;
	}

	@Override
	public List<Question> randomQuestions(Quiz quiz, int numberOfQuestions) {
		List<Question> questionsForQuiz = questionsForQuiz(quiz);
		Random rand = new Random();
		List<Question> randomQuestions = new ArrayList<Question>();
		for (int i = 0; i < numberOfQuestions; i++) {
			int randomIndex = rand.nextInt(questionsForQuiz.size());
			randomQuestions.add(questionsForQuiz.get(randomIndex));
			questionsForQuiz.remove(randomIndex);
		}
		return randomQuestions;
	}

}
