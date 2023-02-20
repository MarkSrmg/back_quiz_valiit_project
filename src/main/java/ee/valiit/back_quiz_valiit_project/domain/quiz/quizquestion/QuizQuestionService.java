package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import ee.valiit.back_quiz_valiit_project.studyhelp.Status;
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
    public List<QuizQuestion> findAllActiveQuizQuestions(Integer quizId, String status) {
        return quizQuestionRepository.findAllActiveQuizQuestions(quizId, status);
    }

    public QuizQuestion findQuizQuestion(Integer quizId, Integer questionId) {
        return quizQuestionRepository.findQuizQuestion(quizId, questionId).get();
    }

    public void saveQuizQuestion(QuizQuestion quizQuestion) {
        quizQuestionRepository.save(quizQuestion);
    }

    public void deleteQuestion(QuizQuestion quizQuestion) {
        quizQuestion.setStatus(Status.DEACTIVATED);
        quizQuestionRepository.save(quizQuestion);
    }

    public QuizQuestion findQuizQuestion(Integer questionId) {
        return quizQuestionRepository.findByQuestion_Id(questionId);
    }
}
