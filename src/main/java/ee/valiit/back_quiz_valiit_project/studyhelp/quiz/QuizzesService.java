package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.*;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Counter;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.CounterService;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestion;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuizQuestionService;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzesService {
    @Resource
    private QuizService quizService;
    @Resource
    private UserService userService;
    @Resource
    private QuizRepository quizRepository;
    @Resource
    private QuizMapper quizMapper;
    @Resource
    private CounterService counterService;

    @Resource
    private QuizQuestionService quizQuestionService;


    public QuizResponse addNewQuiz(Integer userId, QuizRequest quizRequest) {
        User user = userService.findUser(userId);
        Quiz quiz = quizMapper.toEntity(quizRequest);
        quiz.setUser(user);
        quizService.addNewQuiz(quiz);
        return new QuizResponse(quiz.getId());
    }

    public List<QuizDto> getUserLast5Quizzes(Integer userId) {
        List<Quiz> quizzes = quizService.getUserLast5Quizzes(userId);
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getUserQuizzes(Integer userId) {
        List<Quiz> quizzes = quizService.getUserQuizzes(userId);
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getPublicLast5Quizzes() {
        List<Quiz> quizzes = quizService.getPublicLast5Quizzes();
        return quizMapper.toDtos(quizzes);
    }

    public List<QuizDto> getPublicQuizzes() {
        List<Quiz> quizzes = quizService.getPublicQuizzes();
        return quizMapper.toDtos(quizzes);
    }

    public void resetCounter(Integer quizId) {
        Quiz quiz = quizService.findQuiz(quizId);
        List<QuizQuestion> quizQuestions = quizQuestionService.findAllQuestions(quiz.getId());
        for (QuizQuestion quizQuestion : quizQuestions) {
            Counter count = counterService.findQuestionCorrectCount(quizQuestion.getId());
            count.setCorrectCount(0);
            counterService.saveCounter(count);

        }

    }
}



