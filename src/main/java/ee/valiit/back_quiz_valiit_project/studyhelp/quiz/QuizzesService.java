package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.*;
import ee.valiit.back_quiz_valiit_project.domain.user.Status;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.valiit.back_quiz_valiit_project.domain.user.Status.ACTIVE;

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


    public QuizResponse addNewQuiz(Integer userId, QuizRequest quizRequest) {
        User user = userService.findUser(userId);
        Quiz quiz = quizMapper.toEntity(quizRequest);
        quiz.setUser(user);
        quizService.addNewQuiz(quiz);
        return new QuizResponse(quiz.getId());
    }

    public List<QuizDto> getUserQuizzes(Integer userId) {
        List<Quiz> userQuizzes = quizService.getUserQuizzes(userId);
        List<QuizDto> quizzes = quizMapper.toDtos(userQuizzes);
        return quizzes;
    }

    public List<QuizDto> getPublicQuizzes() {
        List<Quiz> publicQuizzes = quizService.getPublicQuizzes();
        List<QuizDto> quizzes = quizMapper.toDtos(publicQuizzes);
        return quizzes;
    }

}
