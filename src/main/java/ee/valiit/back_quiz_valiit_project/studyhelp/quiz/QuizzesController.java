package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;

import ee.valiit.back_quiz_valiit_project.domain.quiz.QuizDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizzesController {

    @Resource
    private QuizzesService quizzesService;


    @PostMapping()
    @Operation(summary = "Create new Quiz", description = "Posts new quiz name and answers needed, and returs quizName and quizId")
    public QuizResponse addNewQuiz(@RequestParam Integer userId, @RequestBody QuizRequest quizRequest) {
        return quizzesService.addNewQuiz(userId, quizRequest);
    }


    @GetMapping("/user")
    @Operation(summary = "Finds all personal quizzes", description = "Finds all quizzes in quiz table by userId and quiz status")
    public List<QuizDto> getUserQuizzes(@RequestParam Integer userId) {
        List<QuizDto> quizzes = quizzesService.getUserQuizzes(userId);
        return quizzes;
    }


    @GetMapping("/public")
    @Operation(summary = "Finds all public quizzes", description = "Finds all active public quizzes in quiz table")
    public List<QuizDto> getPublicQuizzes() {
        List<QuizDto> quizzes = quizzesService.getPublicQuizzes();
        return quizzes;
    }


}
