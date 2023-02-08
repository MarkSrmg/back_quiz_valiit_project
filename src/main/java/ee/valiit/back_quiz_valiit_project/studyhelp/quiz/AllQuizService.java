package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;


import ee.valiit.back_quiz_valiit_project.domain.quiz.Quiz;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AllQuizService {
    @Resource
    private QuizService quizService;

    @Resource
    private QuizMapper quizMapper;

    public QuizResponse addNewQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.toEntity(quizDto);
        quizService.addNewQuiz(quiz);
        return new QuizResponse(quiz.getId());

    }
}
