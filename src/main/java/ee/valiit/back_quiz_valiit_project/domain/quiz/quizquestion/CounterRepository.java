package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CounterRepository extends JpaRepository<Counter, Integer> {
    @Query("select c from Counter c where c.quizQuestion.id = ?1")
    Optional<Counter> findQuestionCount(Integer id);

}