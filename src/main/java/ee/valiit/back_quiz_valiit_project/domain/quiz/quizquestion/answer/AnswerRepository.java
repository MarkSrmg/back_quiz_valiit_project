package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id = ?1")
    List<Answer> findByQuestion_Id(Integer id);

}