package HyperQuiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HyperQuiz.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
	
    Optional<Question> findByText(String text);

}
