package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.QuizQuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlayService {
    @Resource
    private QuizService quizService;
    @Resource
    private QuizQuestionService quizQuestionService;

    public QuestionResponse findQuestion(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
//        quizQuestionService.findQuestions(quiz);

        return null;
    }
}
