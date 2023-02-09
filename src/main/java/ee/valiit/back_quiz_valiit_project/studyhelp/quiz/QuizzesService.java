package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class QuizzesService {
    @Resource
    private QuizService quizService;
    @Resource
    private UserService userService;

    @Resource
    private QuizMapper quizMapper;

    public QuizResponse addNewQuiz(Integer userId, QuizDto quizDto) {
        User user = userService.findUser(userId);
        Quiz quiz = quizMapper.toEntity(quizDto);
        quiz.setUser(user);
        quizService.addNewQuiz(quiz);
        return new QuizResponse(quiz.getId());

    }
}
