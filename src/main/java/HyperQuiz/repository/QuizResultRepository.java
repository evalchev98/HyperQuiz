package HyperQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HyperQuiz.entities.QuizResult;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, String> {

}
