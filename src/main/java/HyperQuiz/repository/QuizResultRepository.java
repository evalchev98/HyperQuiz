package HyperQuiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HyperQuiz.entities.Quiz;
import HyperQuiz.entities.QuizResult;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, String> {
	Optional<QuizResult> findByQuiz(Quiz quiz);
}
