package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {
    @Resource
    private QuizQuestionRepository quizQuestionRepository;

    public List<QuizQuestion> findAllQuestions(Quiz quiz) {
        return quizQuestionRepository.findAllQuestions(quiz.getId());
    }
}
