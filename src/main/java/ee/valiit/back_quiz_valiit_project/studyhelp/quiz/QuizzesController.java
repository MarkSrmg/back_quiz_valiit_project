package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Create new Quiz", description = "Posts new quiz name and answers needed, and returs quizName and quizId")
    public void findUserQuizzes(@RequestParam Integer userId, @RequestBody QuizRequest quizRequest) {
    }


    @GetMapping("/public")
    @Operation(summary = "Create new Quiz", description = "Posts new quiz name and answers needed, and returs quizName and quizId")
    public void findPublicQuizzes(@RequestParam Integer userId, @RequestBody QuizRequest quizRequest) {
    }


}
