package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestion;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {
    @Resource
    private QuizService quizService;
    @Resource
    private QuizQuestionService quizQuestionService;
    @Resource
    private CounterService counterService;

    public QuestionResponse findQuestion(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> allQuestions = quizQuestionService.findAllQuestions(quiz);
        for(QuizQuestion nextQuestion : allQuestions){
           Counter counter = counterService.finfQuestionCount(nextQuestion);
//            if (nextQuestion.getQuiz())
        }

        return null;
    }
}
