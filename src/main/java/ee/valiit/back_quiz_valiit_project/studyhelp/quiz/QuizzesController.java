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
    @Operation(summary = "Create new Quiz", description = "Posts new quiz name and answers needed, and returns quizName and quizId")
    public QuizResponse addNewQuiz(@RequestParam Integer userId, @RequestBody QuizRequest quizRequest) {
        return quizzesService.addNewQuiz(userId, quizRequest);
    }

    @PutMapping()
    @Operation(summary = "Reset a counter value to zero upon refresh ", description = "Finds all questions by quiz ID and resets their counters to zero in 'counter' table")
    public void resetCounter(@RequestParam Integer quizId) {
        quizzesService.resetCounter(quizId);
    }

//    @PutMapping("/edit")
//    @Operation(summary = "Finds all questions by QuizId and enables to edit them", description = "")
//    public List<>


    @GetMapping("/user/last-5")
    @Operation(summary = "Finds last 5 personal quizzes", description = "Finds last 5 active quizzes in quiz table by userId")
    public List<QuizDto> getUserLast5Quizzes(@RequestParam Integer userId) {
        return quizzesService.getUserLast5Quizzes(userId);
    }

    @GetMapping("/user")
    @Operation(summary = "Finds all personal quizzes", description = "Finds all active quizzes in quiz table by userId")
    public List<QuizDto> getUserQuizzes(@RequestParam Integer userId) {
        return quizzesService.getUserQuizzes(userId);
    }

    @GetMapping("/public/last-5")
    @Operation(summary = "Finds last 5 public quizzes", description = "Finds last 5 active public quizzes in quiz table")
    public List<QuizDto> getPublicLast5Quizzes() {
        return quizzesService.getPublicLast5Quizzes();
    }

    @GetMapping("/public")
    @Operation(summary = "Finds all public quizzes", description = "Finds all active public quizzes in quiz table")
    public List<QuizDto> getPublicQuizzes() {
        return quizzesService.getPublicQuizzes();
    }

    @DeleteMapping()
    @Operation(summary = "Deletes Quiz", description = "Finds quiz by quizId, adds timestamp to name and sets status to deactivated")
    public void deleteQuiz(@RequestParam Integer quizId) {
        quizzesService.deleteQuiz(quizId);
    }

    @PostMapping("/public-to-user")
    @Operation(summary = "Creates copy of public quiz", description = "Makes copy of public quiz including data from tables 'quiz', 'quiz_question', 'question' and 'answer'")
    public void copyPublicQuizToUser(@RequestParam Integer quizId, @RequestParam Integer userId) {
        quizzesService.copyPublicQuizToUser(quizId, userId);
    }
}

