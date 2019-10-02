package HyperQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HyperQuiz.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

}
