package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizResponse;
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

    @PutMapping()
    @Operation(summary = "Reset a counter value to zero upon refresh ", description = "Finds all questions by quiz ID and resets their counters to zero in 'counter' table")
    public void resetCounter(@RequestParam Integer quizId) {
        quizzesService.resetCounter(quizId);
    }


    @GetMapping("/user")
    @Operation(summary = "Finds all personal quizzes", description = "Finds all active quizzes in quiz table by userId")
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
