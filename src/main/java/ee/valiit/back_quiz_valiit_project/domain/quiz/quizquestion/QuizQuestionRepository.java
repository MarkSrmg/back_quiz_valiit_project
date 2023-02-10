package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Integer> {
    @Query("select q from QuizQuestion q where q.quiz.id = ?1")
    List<QuizQuestion> findAllQuizQuestions(Integer id);

    @Query("select q from QuizQuestion q where q.quiz.id = ?1 and q.question.id = ?2")
    Optional<QuizQuestion> findQuizQuestion(Integer id, Integer id1);



}