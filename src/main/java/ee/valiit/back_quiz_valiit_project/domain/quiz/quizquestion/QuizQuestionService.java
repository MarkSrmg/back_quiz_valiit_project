package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {
    @Resource
    private QuizQuestionRepository quizQuestionRepository;

    public List<QuizQuestion> findAllQuestions(Integer quizId) {
        return quizQuestionRepository.findAllQuizQuestions(quizId);
    }

    public QuizQuestion findQuizQuestion(Integer quizId, Integer questionId) {
        return quizQuestionRepository.findQuizQuestion(quizId, questionId).get();
    }

    public void saveQuizQuestion(QuizQuestion quizQuestion) {
        quizQuestionRepository.save(quizQuestion);
    }
}
