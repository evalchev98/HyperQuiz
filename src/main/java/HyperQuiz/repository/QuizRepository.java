package HyperQuiz.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HyperQuiz.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz , String> {
    Optional<Quiz> findByName(String name);

}
