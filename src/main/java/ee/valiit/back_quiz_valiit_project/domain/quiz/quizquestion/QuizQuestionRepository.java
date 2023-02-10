package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Integer> {
    @Query("select q from QuizQuestion q where q.quiz.id = ?1")
    List<QuizQuestion> findAllQuestions(Integer id);


}