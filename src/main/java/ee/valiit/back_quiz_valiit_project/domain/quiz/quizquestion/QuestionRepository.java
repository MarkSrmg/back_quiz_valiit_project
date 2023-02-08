package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}