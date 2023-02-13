package ee.valiit.back_quiz_valiit_project.studyhelp.play;

import ee.valiit.back_quiz_valiit_project.infrastructure.error.ApiError;
import ee.valiit.back_quiz_valiit_project.studyhelp.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {
    @Resource
    private PlayService playService;

    @GetMapping("/play")
    @Operation(summary = "finds a question and answers to play", description = "finds all questions from quiz id where correct count is lower than required count and responds with a random one from the list")
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "All questions are answered", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public QuestionResponse findQuiestion(@RequestParam Integer quizId) {
        return playService.findQuestion(quizId);
    }

    @PutMapping("/play")
    @Operation(summary = "increases Correct Question Count")
    public void increaseQuestionCorrectCount(@RequestParam Integer quizId, @RequestParam Integer questionId) {
        playService.increaseQuestionCorrectCount(quizId, questionId);
    }

}
